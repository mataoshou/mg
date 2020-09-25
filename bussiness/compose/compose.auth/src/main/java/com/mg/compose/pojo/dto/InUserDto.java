package com.mg.compose.pojo.dto;

import lombok.Data;

@Data
public class InUserDto{
    private Long userId;
    private String userName;
    private String userWeixin;
    private String userWeibo;
    private String userQq;
    private String userTelephone;
}
