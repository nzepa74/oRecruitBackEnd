package com.spring.boot.development.project.controller;

import com.spring.boot.development.project.dto.RegistrationDto;
import com.spring.boot.development.project.service.RegistrationService;
import com.spring.boot.development.sa.payload.response.MessageResponse;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wso2.client.api.ApiException;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created By zepaG on 6/3/2022.
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/signup")
@AllArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @GetMapping("/getCitizenDetail")
    public ResponseEntity<?> getCitizenDetail(@RequestParam String cid, @DateTimeFormat(pattern = "yyyy-MM-dd") Date dob) throws ParseException, ApiException {
        return registrationService.getCitizenDetails(cid, dob);
    }

//    @PostMapping("/signupNew")
    @RequestMapping(path = "/signupNew", method = POST)
    public ResponseEntity<?> signup(@Valid @RequestBody  RegistrationDto registrationDto) {
//        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
        return registrationService.signup(registrationDto);
    }
}
