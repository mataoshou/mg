package com.mg.compose.pojo.bo;

import lombok.Data;
import org.dozer.Mapping;

import java.util.Date;

@Data
public class UserBo {

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
