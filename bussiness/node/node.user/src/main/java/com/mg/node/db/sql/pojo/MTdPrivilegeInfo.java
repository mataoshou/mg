package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.Table;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import java.util.Date;
import lombok.Data;

@Data
@Table("m_td_privilege_info")
public class MTdPrivilegeInfo {
    @PrimaryId
    private Long id;

    private String pname;

    private String displayName;

    private Date timeCreated;

    private Integer level;

    private Integer prority;
}