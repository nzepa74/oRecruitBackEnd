package com.spring.boot.development.sa.payload.response;

import lombok.Data;

/**
 * Created By zepaG on 5/13/2022.
 */
@Data
public class CurrentUser {
    //region private variables
    private String userId;
    private String username;
    private String fullName;
    private String email;
    //endregion
}
