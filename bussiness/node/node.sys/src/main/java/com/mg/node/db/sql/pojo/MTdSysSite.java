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
    @Column(cloumn= "site_id")
    private Long siteId;

    @Column(cloumn= "site_name")
    private String siteName;

    @Column(cloumn= "site_password")
    private String sitePassword;

    @Column(cloumn= "display_name")
    private String displayName;

    @Column(cloumn= "site_type")
    private Integer siteType;

    @Column(cloumn= "time_created")
    private Date timeCreated;
}