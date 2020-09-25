package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.Column;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import com.mg.node.common.plugin.mybatis.annotations.Table;
import lombok.Data;

@Data
@Table("m_tc_role_privilege_info")
public class MTcRolePrivilegeInfo {
    @PrimaryId
    @Column(cloumn= "tc_id")
    private Long tcId;

    @Column(cloumn= "role_id")
    private Long roleId;

    @Column(cloumn= "privilege_id")
    private Long privilegeId;
}