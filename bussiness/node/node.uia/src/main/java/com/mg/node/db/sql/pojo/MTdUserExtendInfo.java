package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.Column;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import com.mg.node.common.plugin.mybatis.annotations.Table;
import lombok.Data;

@Data
@Table("m_td_user_extend_info")
public class MTdUserExtendInfo {
    @PrimaryId
    @Column(cloumn= "extend_id")
    private String extendId;

    @Column(cloumn= "user_id")
    private String userId;

    @Column(cloumn= "real_name")
    private String realName;

    @Column(cloumn= "spell_name")
    private String spellName;

    @Column(cloumn= "post_name")
    private String postName;

    @Column(cloumn= "duties_name")
    private String dutiesName;

    @Column(cloumn= "office_address")
    private String officeAddress;

    @Column(cloumn= "mobile_phone")
    private String mobilePhone;

    @Column(cloumn= "office_telephone")
    private String officeTelephone;

    private String email;

    @Column(cloumn= "office_code")
    private String officeCode;

    private String description;

    private Integer reserved1;

    private String reserved2;
}