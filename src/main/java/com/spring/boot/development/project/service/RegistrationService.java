package com.spring.boot.development.project.service;

import com.spring.boot.development.project.dto.CitizenDetailDto;
import com.spring.boot.development.project.dto.RegistrationDto;
import com.spring.boot.development.project.dto.SocialMediaDto;
import com.spring.boot.development.project.helper.UuidGenerator;
import com.spring.boot.development.project.model.*;
import com.spring.boot.development.sa.models.ERole;
import com.spring.boot.development.sa.models.Role;
import com.spring.boot.development.sa.models.User;
import com.spring.boot.development.sa.payload.response.MessageResponse;
import com.spring.boot.development.sa.repository.*;
import com.squareup.okhttp.OkHttpClient;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.wso2.client.api.ApiClient;
import org.wso2.client.api.ApiException;
import org.wso2.client.api.DCRC_CitizenDetailsAPI.DefaultApi;
import org.wso2.client.model.DCRC_CitizenDetailsAPI.CitizenDetailsResponse;
import org.wso2.client.model.DCRC_CitizenDetailsAPI.CitizendetailsObj;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created By zepaG on 6/5/2022.
 */
@Service
@AllArgsConstructor
public class RegistrationService {
    //region private variables
    private final CitizenDetailApiService citizenDetailApiService;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;
    private final JobSeekerInfoRepo jobSeekerInfoRepo;
    private final JobSeekerHobbyRepo jobSeekerHobbyRepo;
    private final JobSeekerSkillRepo jobSeekerSkillRepo;
    private final SocialMediaLinkRepo socialMediaLinkRepo;

    //endregion
    public ResponseEntity<?> getCitizenDetails(String cid, Date dob) throws ParseException, ApiException {
        return validateCitizenDetails(cid, dob);
    }

    private ResponseEntity<?> validateCitizenDetails(String cid, Date dob) throws ParseException, ApiException {
        CitizenDetailDto citizenDetailDto = new CitizenDetailDto();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("wsEndPointURL_en_US");
        String getCitizenDetails = resourceBundle.getString("getCitizenDetails.endPointURL");

        OkHttpClient httpClient = new OkHttpClient();
        httpClient.setConnectTimeout(10000, TimeUnit.MILLISECONDS);
        httpClient.setReadTimeout(10000, TimeUnit.MILLISECONDS);

        ApiClient apiClient = new ApiClient();
        apiClient.setHttpClient(httpClient);

        apiClient.setBasePath(getCitizenDetails);
        //for stagging
//            apiClient.setAccessToken("75354085-5182-36f3-a98d-5548dbec5303");

        //region off this in stagging
        Token token = citizenDetailApiService.getApplicationToken();
        apiClient.setAccessToken(token.getAccess_token());
        //endregion

        DefaultApi api = new DefaultApi(apiClient);
        CitizenDetailsResponse citizenDetailsResponse = api.citizendetailsCidGet(cid);
        if (citizenDetailsResponse.getCitizenDetailsResponse().getCitizenDetail() != null && !citizenDetailsResponse.getCitizenDetailsResponse().getCitizenDetail().isEmpty()) {
            CitizendetailsObj citizendetailsObj = citizenDetailsResponse.getCitizenDetailsResponse().getCitizenDetail().get(0);

            citizenDetailDto.setFullName(citizendetailsObj.getFirstName() + " " + citizendetailsObj.getMiddleName() + " " + citizendetailsObj.getLastName());
            citizenDetailDto.setFullName(citizenDetailDto.getFullName().replaceAll("null", ""));

            char genderChar = citizendetailsObj.getGender().charAt(0);
            String genderName = "Male";
            if (genderChar == 'F') {
                genderName = "Female";
            } else if (genderChar == 'O') {
                genderName = "Other";
            }
            citizenDetailDto.setGender(genderName);

            String censusDob = citizendetailsObj.getDob();
            Date citizenDob = new SimpleDateFormat("dd/MM/yyyy").parse(censusDob);

            if (!citizenDob.toString().equals(dob.toString())) {
                return ResponseEntity.badRequest().body(new MessageResponse("CID and date of birth did not matched."));
            }
            citizenDetailDto.setDob(censusDob);
            citizenDetailDto.setCid(citizendetailsObj.getCid());
            citizenDetailDto.setFatherName(citizendetailsObj.getFatherName());
            citizenDetailDto.setVillageName(citizendetailsObj.getVillageName());
            citizenDetailDto.setGeogName(citizendetailsObj.getGewogName());
            citizenDetailDto.setDzongkhagName(citizendetailsObj.getDzongkhagName());
        } else {
            return ResponseEntity.badRequest().body(new MessageResponse("No information found matching CID No " + cid));
        }
        return ResponseEntity.ok(citizenDetailDto);
    }

    @Transactional(rollbackOn = Exception.class)
    public ResponseEntity<?> signup(RegistrationDto registrationDto) {
        if (userRepository.existsByUsername(registrationDto.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Username is already taken. Please try different one."));
        }
        if (userRepository.existsByEmail(registrationDto.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Email is already in use. Please try different one."));
        }
        // Create new user's account
        User user = new User(registrationDto.getFullName(), registrationDto.getUsername(), registrationDto.getEmail(), encoder.encode(registrationDto.getPassword()));

        Set<String> strRoles = registrationDto.getRole();
        Set<Role> roles = new HashSet<>();
        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin" -> {
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                    }
                    case "mod" -> {
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);
                    }
                    default -> {
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                    }
                }
            });
        }
        user.setRoles(roles);
        user.setUserId(UuidGenerator.generateUuid());
        userRepository.save(user);
        //save job seeker information
        JobSeekerInfo jobSeekerInfo = new ModelMapper().map(registrationDto, JobSeekerInfo.class);
        jobSeekerInfo.setJobSeekerInfoId(UuidGenerator.generateUuid());
        jobSeekerInfo.setUserId(user.getUserId());
        jobSeekerInfo.setCreatedBy(user.getUserId());
        jobSeekerInfo.setCreatedDate(new Date());
        jobSeekerInfoRepo.save(jobSeekerInfo);
        //save skill
        JobSeekerSkill jobSeekerSkill = new ModelMapper().map(registrationDto, JobSeekerSkill.class);
        jobSeekerSkill.setSkillId(UuidGenerator.generateUuid());
        jobSeekerSkill.setUserId(user.getUserId());
        jobSeekerSkill.setCreatedBy(user.getUserId());
        jobSeekerSkill.setCreatedDate(new Date());
        jobSeekerSkillRepo.save(jobSeekerSkill);
        //save hobby
        JobSeekerHobby jobSeekerHobby = new ModelMapper().map(registrationDto, JobSeekerHobby.class);
        jobSeekerHobby.setHobbyId(UuidGenerator.generateUuid());
        jobSeekerHobby.setUserId(user.getUserId());
        jobSeekerHobby.setCreatedBy(user.getUserId());
        jobSeekerHobby.setCreatedDate(new Date());
        jobSeekerHobbyRepo.save(jobSeekerHobby);
        //save social media links
        //  try with for each and lamda expression
        List<SocialMediaDto> socialMediaDtos = registrationDto.getSocialMediaDtos();
        socialMediaDtos.forEach(socialMediaDto -> {
            SocialMedia socialMedia = new ModelMapper().map(socialMediaDto, SocialMedia.class);
            socialMedia.setSocialMediaId(UuidGenerator.generateUuid());
            socialMedia.setUserId(user.getUserId());
            socialMedia.setCreatedBy(user.getUserId());
            socialMedia.setCreatedDate(new Date());
            socialMediaLinkRepo.save(socialMedia);
        });
//        for (SocialMediaDto socialMediaDto : registrationDto.getSocialMediaDtos()) {
//            SocialMedia socialMedia = new ModelMapper().map(socialMediaDto, SocialMedia.class);
//            socialMedia.setSocialMediaId(UuidGenerator.generateUuid());
//            socialMedia.setUserId(user.getUserId());
//            socialMedia.setCreatedBy(user.getUserId());
//            socialMedia.setCreatedDate(new Date());
//            socialMediaLinkRepo.save(socialMedia);
//        }
        return ResponseEntity.ok(new MessageResponse("Registered successfully. Pleas login in using email and password."));
    }
}
