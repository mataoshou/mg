package com.mg.compose.pojo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InSysConfigDto {
    private Long id;

    private String name;

    private Integer showtype;

    private Integer controltype;

    private String value;

    private String datasource;

    private String description;

    private Long siteid;
}
