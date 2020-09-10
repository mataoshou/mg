package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import com.mg.node.common.plugin.mybatis.annotations.Table;
import java.util.Date;
import lombok.Data;

@Data
@Table("m_td_sys_site")
public class MTdSysSite {
    @PrimaryId
    private Long id;

    private String siteName;

    private String password;

    private String displayName;

    private Integer siteType;

    private Date timeCreated;
}