package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.Column;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import com.mg.node.common.plugin.mybatis.annotations.Table;
import lombok.Data;

@Data
@Table("m_td_department_extend_info")
public class MTdDepartmentExtendInfo {
    @PrimaryId
    @Column(cloumn= "extend_id")
    private String extendId;

    @Column(cloumn= "department_id")
    private String departmentId;

    @Column(cloumn= "department_addr")
    private String departmentAddr;

    @Column(cloumn= "worker_number")
    private Integer workerNumber;

    private Integer reserved1;

    private String reserved2;
}