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
    @Column(cloumn= "siteId")
    private Long siteid;

    @Column(cloumn= "siteName")
    private String sitename;

    private String password;

    @Column(cloumn= "displayName")
    private String displayname;

    @Column(cloumn= "siteType")
    private Integer sitetype;

    @Column(cloumn= "timeCreated")
    private Date timecreated;
}