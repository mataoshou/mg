package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.Column;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import com.mg.node.common.plugin.mybatis.annotations.Table;
import java.util.Date;
import lombok.Data;

@Data
@Table("m_td_user_login_info")
public class MTdUserLoginInfo {
    @PrimaryId
    @Column(cloumn= "login_id")
    private String loginId;

    @Column(cloumn= "user_id")
    private String userId;

    @Column(cloumn= "login_ip")
    private String loginIp;

    @Column(cloumn= "time_login")
    private Date timeLogin;

    @Column(cloumn= "time_logout")
    private Integer timeLogout;

    private Integer reserved1;

    private String reserved2;
}