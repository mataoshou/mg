package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.Column;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import com.mg.node.common.plugin.mybatis.annotations.Table;
import java.util.Date;
import lombok.Data;

@Data
@Table("m_tc_user_actor_info")
public class MTcUserActorInfo {
    @PrimaryId
    @Column(cloumn= "tc_id")
    private String tcId;

    @Column(cloumn= "user_id")
    private String userId;

    @Column(cloumn= "department_id")
    private String departmentId;

    @Column(cloumn= "actor_group_id")
    private String actorGroupId;

    @Column(cloumn= "specially_group_id")
    private String speciallyGroupId;

    @Column(cloumn= "time_created")
    private Date timeCreated;

    @Column(cloumn= "creator_id")
    private String creatorId;

    private String description;

    private String reserved1;

    private String reserved2;
}