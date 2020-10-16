package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.Column;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import com.mg.node.common.plugin.mybatis.annotations.Table;
import lombok.Data;

@Data
@Table("m_tc_privilege_group_info")
public class MTcPrivilegeGroupInfo {
    @PrimaryId
    @Column(cloumn= "tc_id")
    private String tcId;

    @Column(cloumn= "privilege_group_name")
    private String privilegeGroupName;

    @Column(cloumn= "privilege_group_type")
    private Integer privilegeGroupType;

    @Column(cloumn= "privilege_set")
    private String privilegeSet;

    private String description;

    @Column(cloumn= "show_order")
    private Integer showOrder;

    private Integer reserved1;

    private String reserved2;
}