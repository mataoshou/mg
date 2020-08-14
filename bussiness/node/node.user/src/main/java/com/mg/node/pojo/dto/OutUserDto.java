package com.mg.node.pojo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OutUserDto {
    private Long id;
    private String name;
    private String password;
    private String weixin;
    private String weibo;
    private String qq;
    private String telephone;
    private String displayname;
    private Date timecreated;
    private Integer level;
    private Integer statadelete;
    private Date timedelete;
}
