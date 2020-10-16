package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.Column;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import com.mg.node.common.plugin.mybatis.annotations.Table;
import lombok.Data;

@Data
@Table("m_td_privilege_info")
public class MTdPrivilegeInfo {
    @PrimaryId
    @Column(cloumn= "privilege_id")
    private String privilegeId;

    @Column(cloumn= "privilege_name")
    private String privilegeName;

    @Column(cloumn= "operate_group_id")
    private String operateGroupId;

    private String description;

    @Column(cloumn= "show_order")
    private Integer showOrder;

    private Integer reserved1;

    private String reserved2;
}