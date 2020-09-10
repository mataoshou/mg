package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.Table;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import java.util.Date;
import lombok.Data;

@Data
@Table("m_td_action_info")
public class MTdActionInfo {
    @PrimaryId
    private Long id;

    private String url;

    private String displayName;

    private Date timeCreated;

    private String privilege;

    private Long siteId;
}