package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.Table;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import lombok.Data;

@Data
@Table("m_td_role_info")
public class MTdRoleInfo {
    @PrimaryId
    private Long id;

    private String roleName;

    private String displayName;

    private Integer siteId;
}