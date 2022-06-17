package com.spring.boot.development.project.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created By zepaG on 3/13/2022.
 */
@Setter
@Getter
public class FilesDto {
    private  MultipartFile profilePic;
}
