package com.mg.compose.pojo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OutUserDto {
    private Long userId;
    private String userName;
    private String userPassword;
    private String userWeixin;
    private String userWeibo;
    private String userQq;
    private String userTelephone;
    private String userDisplayname;
    private Date timeCreated;
    private Integer userLevel;
}
