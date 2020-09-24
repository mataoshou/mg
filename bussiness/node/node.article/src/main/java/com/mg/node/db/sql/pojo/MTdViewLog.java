package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.Column;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import com.mg.node.common.plugin.mybatis.annotations.Table;
import java.util.Date;
import lombok.Data;

@Data
@Table("m_td_view_log")
public class MTdViewLog {
    private Long id;

    @Column(cloumn= "vSrc")
    private String vsrc;

    @Column(cloumn= "vIp")
    private String vip;

    private String msg;

    @Column(cloumn= "time_created")
    private Date timeCreated;

    private Long count;
}