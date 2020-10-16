package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.Column;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import com.mg.node.common.plugin.mybatis.annotations.Table;
import lombok.Data;

@Data
@Table("m_td_organization_extend_info")
public class MTdOrganizationExtendInfo {
    @PrimaryId
    @Column(cloumn= "extend_id")
    private String extendId;

    @Column(cloumn= "organization_id")
    private String organizationId;

    @Column(cloumn= "organization_address")
    private String organizationAddress;

    private Integer reserved1;

    private String reserved2;
}