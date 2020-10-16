package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.Column;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import com.mg.node.common.plugin.mybatis.annotations.Table;
import java.util.Date;
import lombok.Data;

@Data
@Table("m_td_organization_info")
public class MTdOrganizationInfo {
    @PrimaryId
    @Column(cloumn= "organization_id")
    private String organizationId;

    @Column(cloumn= "organization_code")
    private String organizationCode;

    @Column(cloumn= "organization_name")
    private String organizationName;

    @Column(cloumn= "organization_type")
    private Integer organizationType;

    private String description;

    @Column(cloumn= "time_created")
    private Date timeCreated;

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