package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.Column;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import com.mg.node.common.plugin.mybatis.annotations.Table;
import java.util.Date;
import lombok.Data;

@Data
@Table("m_td_department_chart_info")
public class MTdDepartmentChartInfo {
    @PrimaryId
    @Column(cloumn= "chart_id")
    private String chartId;

    @Column(cloumn= "department_id")
    private String departmentId;

    @Column(cloumn= "department_name")
    private String departmentName;

    @Column(cloumn= "organization_id")
    private String organizationId;

    @Column(cloumn= "level_info")
    private String levelInfo;

    @Column(cloumn= "parent_department_id")
    private String parentDepartmentId;

    @Column(cloumn= "show_order")
    private Integer showOrder;

    @Column(cloumn= "time_created")
    private Date timeCreated;

    @Column(cloumn= "creator_id")
    private String creatorId;

    @Column(cloumn= "time_modify")
    private Date timeModify;

    @Column(cloumn= "modifies_id")
    private String modifiesId;

    private Integer reserved1;

    private String reserved2;
}