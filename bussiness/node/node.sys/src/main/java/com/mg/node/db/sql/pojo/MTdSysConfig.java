package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.Column;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import com.mg.node.common.plugin.mybatis.annotations.Table;
import lombok.Data;

@Data
@Table("m_td_sys_config")
public class MTdSysConfig {
    @PrimaryId
    @Column(cloumn= "configId")
    private Long configid;

    @Column(cloumn= "configName")
    private String configname;

    @Column(cloumn= "showType")
    private Integer showtype;

    @Column(cloumn= "controlType")
    private Integer controltype;

    @Column(cloumn= "configValue")
    private String configvalue;

    @Column(cloumn= "dataSource")
    private String datasource;

    private String description;

    @Column(cloumn= "siteId")
    private Long siteid;
}