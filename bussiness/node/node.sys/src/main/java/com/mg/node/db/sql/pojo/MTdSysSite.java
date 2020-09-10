package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.Column;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import com.mg.node.common.plugin.mybatis.annotations.Table;
import java.util.Date;
import lombok.Data;

@Data
@Table("m_td_sys_site")
public class MTdSysSite {
    @PrimaryId
    @Column(cloumn= "id")
    private Long id;

    @Column(cloumn= "siteName")
    private String siteName;

    @Column(cloumn= "password")
    private String password;

    @Column(cloumn= "displayName")
    private String displayName;

    @Column(cloumn= "siteType")
    private Integer siteType;

    @Column(cloumn= "timeCreated")
    private Date timeCreated;
}