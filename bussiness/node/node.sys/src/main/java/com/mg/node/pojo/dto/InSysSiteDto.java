package com.mg.node.pojo.dto;

import com.mg.node.common.plugin.mybatis.annotations.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
public class InSysSiteDto {
    private Long siteId;
    private String siteName;
    private String sitePassword;
    private Integer siteType;
}
