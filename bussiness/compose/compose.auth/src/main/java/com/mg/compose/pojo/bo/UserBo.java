package com.mg.compose.pojo.bo;

import lombok.Data;
import org.dozer.Mapping;

import java.util.Date;

@Data
public class UserBo {

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
    private String privileges;


}
