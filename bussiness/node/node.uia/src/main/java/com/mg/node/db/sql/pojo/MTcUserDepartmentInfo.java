package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.Column;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import com.mg.node.common.plugin.mybatis.annotations.Table;
import lombok.Data;

@Data
@Table("m_tc_user_department_info")
public class MTcUserDepartmentInfo {
    @PrimaryId
    @Column(cloumn= "tc_id")
    private String tcId;

    @Column(cloumn= "user_id")
    private String userId;

    @Column(cloumn= "department_id")
    private String departmentId;

    @Column(cloumn= "show_order")
    private Integer showOrder;

    private Integer reserved1;

    private String reserved2;
}