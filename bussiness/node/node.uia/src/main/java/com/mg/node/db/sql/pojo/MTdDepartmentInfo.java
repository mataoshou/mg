package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.Column;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import com.mg.node.common.plugin.mybatis.annotations.Table;
import java.util.Date;
import lombok.Data;

@Data
@Table("m_td_department_info")
public class MTdDepartmentInfo {
    @PrimaryId
    @Column(cloumn= "department_id")
    private String departmentId;

    @Column(cloumn= "department_code")
    private String departmentCode;

    @Column(cloumn= "department_name")
    private String departmentName;

    @Column(cloumn= "department_type")
    private String departmentType;

    private String description;

    @Column(cloumn= "createdTime")
    private Date createdtime;

    @Column(cloumn= "creator_id")
    private String creatorId;

    @Column(cloumn= "time_modify")
    private Date timeModify;

    @Column(cloumn= "modifies_id")
    private String modifiesId;

    @Column(cloumn= "time_deleted")
    private Date timeDeleted;

    @Column(cloumn= "deletor_id")
    private String deletorId;

    @Column(cloumn= "deleted_flag")
    private Byte deletedFlag;

    private Integer reserved1;

    private String reserved2;
}