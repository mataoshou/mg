package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.Column;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import com.mg.node.common.plugin.mybatis.annotations.Table;
import lombok.Data;

@Data
@Table("m_tc_organization_department_info")
public class MTcOrganizationDepartmentInfo {
    @PrimaryId
    @Column(cloumn= "tc_id")
    private String tcId;

    @Column(cloumn= "departement_id")
    private String departementId;

    @Column(cloumn= "organization_id")
    private String organizationId;

    private Integer reserved1;

    private String reserved2;
}