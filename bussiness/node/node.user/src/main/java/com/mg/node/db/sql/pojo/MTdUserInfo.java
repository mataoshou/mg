package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.Table;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import java.util.Date;
import lombok.Data;

@Data
@Table("m_td_user_info")
public class MTdUserInfo {
    @PrimaryId
    private Long id;

    private String name;

    private String password;

    private String weixin;

    private String weibo;

    private String qq;

    private String telephone;

    private String displayName;

    private Date timeCreated;

    private Integer level;

    private Integer stataDelete;

    private Date timeDelete;
}