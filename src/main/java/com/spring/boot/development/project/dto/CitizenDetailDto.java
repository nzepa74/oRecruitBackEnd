package com.spring.boot.development.project.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created By zepaG on 3/13/2022.
 */
@Setter
@Getter
public class CitizenDetailDto {
    private String fullName;
    private String gender;
    private String cid;
    private String dob;
    private String fatherName;
    private String villageName;
    private String geogName;
    private String dzongkhagName;

    public CitizenDetailDto() {
    }
}
