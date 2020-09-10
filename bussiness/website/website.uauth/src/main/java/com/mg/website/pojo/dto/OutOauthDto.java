package com.mg.website.pojo.dto;

import lombok.Data;

@Data
public class OutOauthDto {

    private String access_token;
    private String token_type;
    private String refresh_token;
    private long userId;
}
