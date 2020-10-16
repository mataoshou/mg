package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.Column;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import com.mg.node.common.plugin.mybatis.annotations.Table;
import java.util.Date;
import lombok.Data;

@Data
@Table("m_td_actor_info")
public class MTdActorInfo {
    @PrimaryId
    @Column(cloumn= "actor_id")
    private String actorId;

    @Column(cloumn= "actor_name")
    private String actorName;

    @Column(cloumn= "time_create")
    private Date timeCreate;

    @Column(cloumn= "secret_level")
    private Integer secretLevel;

    private String description;

    @Column(cloumn= "show_order")
    private Integer showOrder;

    @Column(cloumn= "system_flag")
    private String systemFlag;

    private Integer reserved1;

    private String reserved2;

    @Column(cloumn= "privilege_group_id")
    private String privilegeGroupId;
}