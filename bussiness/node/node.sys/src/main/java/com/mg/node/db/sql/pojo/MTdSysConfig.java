package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import com.mg.node.common.plugin.mybatis.annotations.Table;
import lombok.Data;

@Data
@Table("m_td_sys_config")
public class MTdSysConfig {
    @PrimaryId
    private Long id;

    private String name;

    private Integer showType;

    private Integer controlType;

    private String value;

    private String dataSource;

    private String description;

    private Long siteId;
}