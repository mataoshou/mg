package com.mg.node.pojo.dto;

import com.mg.node.common.plugin.mybatis.annotations.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InSysConfigDto {
    private Long configId;
    private String configName;
    private Integer showType;
    private Long siteId;
}
