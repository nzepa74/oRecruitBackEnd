package com.spring.boot.development.project.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

/**
 * Created By zepaG on 3/13/2022.
 */
@Setter
@Getter
public class RegistrationDto {
    private String username;
    private String cid;
    private String dob;
    private String fullName;
    private String mobileNo;
    private String email;
    private String currentAddress;
    private String password;
    private String description;
//    private String fatherName;
//    private String villageName;
//    private String geogName;
//    private String dzongkhagName;
    private String skill;
    private String hobby;
//        private MultipartFile profilePic;
//    private byte[] logo;
    private List<SocialMediaDto> socialMediaDtos;
    private Set<String> role;
}
