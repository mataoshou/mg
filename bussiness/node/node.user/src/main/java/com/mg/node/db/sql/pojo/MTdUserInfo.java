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
    private Long userId;

    @Column(cloumn= "user_name")
    private String userName;

    @Column(cloumn= "user_password")
    private String userPassword;

    @Column(cloumn= "user_weixin")
    private String userWeixin;

    @Column(cloumn= "user_weibo")
    private String userWeibo;

    @Column(cloumn= "user_QQ")
    private String userQq;

    @Column(cloumn= "user_telephone")
    private String userTelephone;

    @Column(cloumn= "user_displayName")
    private String userDisplayname;

    @Column(cloumn= "time_created")
    private Date timeCreated;

    @Column(cloumn= "user_level")
    private Integer userLevel;

    @Column(cloumn= "user_state_delete")
    private Integer userStateDelete;

    @Column(cloumn= "time_delete")
    private Date timeDelete;
}