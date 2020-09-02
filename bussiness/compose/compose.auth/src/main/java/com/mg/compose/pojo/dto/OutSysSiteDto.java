package com.mg.compose.pojo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OutSysSiteDto {
    private Long id;

    private String siteName;

    private String password;

    private String displayName;

    private Integer siteType;

    private Date timeCreated;
}
