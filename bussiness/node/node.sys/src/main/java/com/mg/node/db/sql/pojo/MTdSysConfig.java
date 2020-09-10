package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.Column;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import com.mg.node.common.plugin.mybatis.annotations.Table;
import lombok.Data;

@Data
@Table("m_td_sys_config")
public class MTdSysConfig {
    @PrimaryId
    @Column(cloumn= "id")
    private Long id;

    @Column(cloumn= "name")
    private String name;

    @Column(cloumn= "showType")
    private Integer showType;

    @Column(cloumn= "controlType")
    private Integer controlType;

    @Column(cloumn= "value")
    private String value;

    @Column(cloumn= "dataSource")
    private String dataSource;

    @Column(cloumn= "description")
    private String description;

    @Column(cloumn= "siteId")
    private Long siteId;
}