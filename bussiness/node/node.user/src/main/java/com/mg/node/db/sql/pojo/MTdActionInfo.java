package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.Column;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import com.mg.node.common.plugin.mybatis.annotations.Table;
import java.util.Date;
import lombok.Data;

@Data
@Table("m_td_action_info")
public class MTdActionInfo {
    @Column(cloumn= "action_id")
    private Long actionId;

    @Column(cloumn= "action_url")
    private String actionUrl;

    @Column(cloumn= "action_displayname")
    private String actionDisplayname;

    @Column(cloumn= "time_created")
    private Date timeCreated;

    @Column(cloumn= "privilege_ids")
    private String privilegeIds;

    @Column(cloumn= "site_id")
    private Long siteId;
}