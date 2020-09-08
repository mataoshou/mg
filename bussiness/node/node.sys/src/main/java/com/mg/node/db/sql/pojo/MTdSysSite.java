package com.mg.node.db.sql.pojo;

import com.mg.node.common.frame.mgmybatis.annotations.MgColumn;
import com.mg.node.common.frame.mgmybatis.annotations.MgId;
import com.mg.node.common.frame.mgmybatis.annotations.MgTable;
import java.util.Date;
import lombok.Data;

@Data
@MgTable("m_td_sys_site")
public class MTdSysSite {
    @MgId
    private Long id;

    private String siteName;

    private String password;

    private String displayName;

    private Integer siteType;

    private Date timeCreated;
}