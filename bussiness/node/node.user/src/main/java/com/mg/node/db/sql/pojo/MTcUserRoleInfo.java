package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.Column;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import com.mg.node.common.plugin.mybatis.annotations.Table;
import lombok.Data;

@Data
@Table("m_tc_user_role_info")
public class MTcUserRoleInfo {
    @PrimaryId
    @Column(cloumn= "tc_id")
    private Long tcId;

    @Column(cloumn= "user_id")
    private Long userId;

    @Column(cloumn= "role_id")
    private Long roleId;
}