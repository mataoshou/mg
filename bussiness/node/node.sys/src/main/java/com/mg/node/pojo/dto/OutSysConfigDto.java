package com.mg.node.pojo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OutSysConfigDto {

    private Long id;

    private String configName;

    private Integer showType;

    private Integer controlType;

    private String configValue;

    private String dataSource;

    private String description;

    private Long siteId;
}
