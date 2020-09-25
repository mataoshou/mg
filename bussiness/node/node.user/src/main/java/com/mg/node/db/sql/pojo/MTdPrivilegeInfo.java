package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.Column;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import com.mg.node.common.plugin.mybatis.annotations.Table;
import java.util.Date;
import lombok.Data;

@Data
@Table("m_td_privilege_info")
public class MTdPrivilegeInfo {
    @PrimaryId
    @Column(cloumn= "privilege_id")
    private Long privilegeId;

    @Column(cloumn= "privilege_name")
    private String privilegeName;

    @Column(cloumn= "privilege_displayname")
    private String privilegeDisplayname;

    @Column(cloumn= "time_created")
    private Date timeCreated;

    @Column(cloumn= "privilege_level")
    private Integer privilegeLevel;

    @Column(cloumn= "privilege_prority")
    private Integer privilegePrority;
}