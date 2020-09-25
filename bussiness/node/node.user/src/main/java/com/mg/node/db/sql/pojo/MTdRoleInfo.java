package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.Column;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import com.mg.node.common.plugin.mybatis.annotations.Table;
import lombok.Data;

@Data
@Table("m_td_role_info")
public class MTdRoleInfo {
    @PrimaryId
    @Column(cloumn= "role_id")
    private Long roleId;

    @Column(cloumn= "role_name")
    private String roleName;

    @Column(cloumn= "role_displayname")
    private String roleDisplayname;

    @Column(cloumn= "site_id")
    private Integer siteId;
}