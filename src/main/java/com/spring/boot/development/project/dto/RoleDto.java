package com.spring.boot.development.project.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created By zepaG on 3/13/2022.
 */
@Setter
@Getter
public class RoleDto {
    private String userId;
    private String name;
    private Boolean isChecked;
}
