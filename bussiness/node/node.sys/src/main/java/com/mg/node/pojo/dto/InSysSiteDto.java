package com.mg.node.pojo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class InSysSiteDto {
    private Long id;

    private String siteName;

    private String password;

    private Integer siteType;

}
