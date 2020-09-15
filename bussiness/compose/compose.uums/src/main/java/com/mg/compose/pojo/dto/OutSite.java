package com.mg.compose.pojo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OutSite {

    private Long siteid;

    private String sitename;

    private String password;

    private String displayname;

    private Integer sitetype;

    private Date timecreated;
}