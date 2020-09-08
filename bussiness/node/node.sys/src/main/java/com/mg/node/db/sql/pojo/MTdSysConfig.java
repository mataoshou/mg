package com.mg.node.db.sql.pojo;

import com.mg.node.common.frame.mgmybatis.annotations.MgColumn;
import com.mg.node.common.frame.mgmybatis.annotations.MgId;
import com.mg.node.common.frame.mgmybatis.annotations.MgTable;
import lombok.Data;

@Data
@MgTable("m_td_sys_config")
public class MTdSysConfig {
    @MgId
    private Long id;

    private String name;

    private Integer showType;

    private Integer controlType;

    private String value;

    private String dataSource;

    private String description;

    private Long siteId;
}