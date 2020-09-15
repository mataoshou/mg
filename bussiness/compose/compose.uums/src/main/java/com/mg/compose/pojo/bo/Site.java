package com.mg.compose.pojo.bo;

import lombok.Data;

import java.util.Date;

@Data
public class Site {
    private Long siteid;

    private String sitename;

    private String password;

    private String displayname;

    private Integer sitetype;

    private Date timecreated;
}
