package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.Column;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import com.mg.node.common.plugin.mybatis.annotations.Table;
import lombok.Data;

@Data
@Table("m_td_operate_info")
public class MTdOperateInfo {
    @PrimaryId
    @Column(cloumn= "operate_id")
    private String operateId;

    @Column(cloumn= "operate_name")
    private String operateName;

    @Column(cloumn= "operate_type")
    private Integer operateType;

    @Column(cloumn= "belong_system")
    private String belongSystem;

    @Column(cloumn= "page_location")
    private String pageLocation;

    @Column(cloumn= "area_location")
    private String areaLocation;

    @Column(cloumn= "application_key")
    private String applicationKey;

    private Integer visibility;

    private Integer operability;

    @Column(cloumn= "required_field")
    private Integer requiredField;

    private String description;

    private Integer reserved1;

    private String reserved2;
}