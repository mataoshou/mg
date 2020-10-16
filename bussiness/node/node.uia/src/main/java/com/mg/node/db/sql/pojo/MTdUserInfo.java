package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.Column;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import com.mg.node.common.plugin.mybatis.annotations.Table;
import java.util.Date;
import lombok.Data;

@Data
@Table("m_td_user_info")
public class MTdUserInfo {
    @PrimaryId
    @Column(cloumn= "user_id")
    private String userId;

    @Column(cloumn= "user_code")
    private String userCode;

    @Column(cloumn= "user_name")
    private String userName;

    @Column(cloumn= "user_password")
    private String userPassword;

    @Column(cloumn= "user_displayname")
    private String userDisplayname;

    @Column(cloumn= "user_thumb")
    private String userThumb;

    @Column(cloumn= "user_workcode")
    private String userWorkcode;

    @Column(cloumn= "user_oganization_id")
    private String userOganizationId;

    @Column(cloumn= "user_department_id")
    private String userDepartmentId;

    @Column(cloumn= "user_extend_id")
    private String userExtendId;

    @Column(cloumn= "time_created")
    private Date timeCreated;

    @Column(cloumn= "create_id")
    private String createId;

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

    @Column(cloumn= "time_limited")
    private Date timeLimited;

    @Column(cloumn= "count_login")
    private Byte countLogin;

    @Column(cloumn= "condition_select")
    private Byte conditionSelect;

    @Column(cloumn= "system_flag")
    private Byte systemFlag;

    private Integer reserved1;

    private String reserved2;
}