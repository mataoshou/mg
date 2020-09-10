package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.Table;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import lombok.Data;

@Data
@Table("m_tc_user_role_info")
public class MTcUserRoleInfo {
    @PrimaryId
    private Long id;

    private Long userId;

    private Long roleId;
}