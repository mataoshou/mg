package com.mg.node.pojo.dto;

import com.mg.node.common.plugin.mybatis.annotations.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OutSysConfigDto {
    private Long configId;
    private String configName;
    private Integer showType;
    private Integer controlType;
    private String configValue;
    private String dataSource;
    private String configDescription;
    private Long siteId;
}
