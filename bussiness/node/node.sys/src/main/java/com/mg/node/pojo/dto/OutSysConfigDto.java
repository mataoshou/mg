package com.mg.node.pojo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OutSysConfigDto {

    private Long id;

    private String name;

    private Integer showtype;

    private Integer controltype;

    private String value;

    private String datasource;

    private String description;

    private Long siteid;

    private String sitename;
}
