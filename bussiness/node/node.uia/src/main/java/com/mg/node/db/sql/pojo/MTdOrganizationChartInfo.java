package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.Column;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import com.mg.node.common.plugin.mybatis.annotations.Table;
import java.util.Date;
import lombok.Data;

@Data
@Table("m_td_organization_chart_info")
public class MTdOrganizationChartInfo {
    @PrimaryId
    @Column(cloumn= "chart_id")
    private String chartId;

    @Column(cloumn= "organization_id")
    private String organizationId;

    @Column(cloumn= "organization_code")
    private String organizationCode;

    @Column(cloumn= "organizationName")
    private String organizationname;

    @Column(cloumn= "level_info")
    private String levelInfo;

    @Column(cloumn= "parent_id")
    private String parentId;

    @Column(cloumn= "show_order")
    private Integer showOrder;

    @Column(cloumn= "time_created")
    private Date timeCreated;

    @Column(cloumn= "creator_id")
    private String creatorId;

    @Column(cloumn= "time_modify")
    private Date timeModify;

    @Column(cloumn= "modifies_id")
    private String modifiesId;

    private Integer reserved1;

    private String reserved2;
}