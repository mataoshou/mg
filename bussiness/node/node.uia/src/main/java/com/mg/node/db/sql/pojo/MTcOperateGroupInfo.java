package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.Column;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import com.mg.node.common.plugin.mybatis.annotations.Table;
import lombok.Data;

@Data
@Table("m_tc_operate_group_info")
public class MTcOperateGroupInfo {
    @PrimaryId
    @Column(cloumn= "tc_id")
    private String tcId;

    @Column(cloumn= "operate_group_name")
    private String operateGroupName;

    @Column(cloumn= "operate_group_type")
    private Integer operateGroupType;

    @Column(cloumn= "belong_system")
    private String belongSystem;

    private String description;

    @Column(cloumn= "show_order")
    private Integer showOrder;

    private Integer reserved1;

    private String reserved2;

    @Column(cloumn= "opreate_set")
    private String opreateSet;
}