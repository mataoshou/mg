package com.mg.website.pojo.dto.in;

import lombok.Data;

@Data
public class InOauthDto {

    private String client_id;
    private String client_secret;

    private String grant_type;

    private String username;
    private String password;

}
