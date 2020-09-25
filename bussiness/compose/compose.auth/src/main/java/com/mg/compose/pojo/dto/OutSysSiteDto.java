package com.mg.compose.pojo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OutSysSiteDto {
    private Long siteId;
    private String siteName;
    private String sitePassword;
    private String displayName;
    private Integer siteType;
    private Date timeCreated;
}
