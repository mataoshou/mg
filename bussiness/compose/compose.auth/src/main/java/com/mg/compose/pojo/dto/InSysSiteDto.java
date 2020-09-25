package com.mg.compose.pojo.dto;

import lombok.Data;

@Data
public class InSysSiteDto {
    private Long siteId;
    private String siteName;
    private String sitePassword;
    private Integer siteType;
}
