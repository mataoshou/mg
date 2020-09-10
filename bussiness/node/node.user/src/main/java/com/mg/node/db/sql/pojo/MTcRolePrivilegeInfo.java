package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.Table;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import lombok.Data;

@Data
@Table("m_tc_role_privilege_info")
public class MTcRolePrivilegeInfo {
    @PrimaryId
    private Long id;

    private Long roleId;

    private Long privilegeId;
}