package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.Column;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import com.mg.node.common.plugin.mybatis.annotations.Table;
import lombok.Data;

@Data
@Table("m_td_sys_config")
public class MTdSysConfig {
    @PrimaryId
    @Column(cloumn= "config_id")
    private Long configId;

    @Column(cloumn= "config_name")
    private String configName;

    @Column(cloumn= "show_type")
    private Integer showType;

    @Column(cloumn= "control_type")
    private Integer controlType;

    @Column(cloumn= "config_value")
    private String configValue;

    @Column(cloumn= "data_source")
    private String dataSource;

    @Column(cloumn= "config_description")
    private String configDescription;

    @Column(cloumn= "site_id")
    private Long siteId;
}