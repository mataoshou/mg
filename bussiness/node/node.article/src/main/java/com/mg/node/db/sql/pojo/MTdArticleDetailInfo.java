package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.Column;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import com.mg.node.common.plugin.mybatis.annotations.Table;
import lombok.Data;

@Data
@Table("m_td_article_detail_info")
public class MTdArticleDetailInfo {
    @PrimaryId
    private Long id;

    private Integer status;

    @Column(cloumn= "link_items")
    private String linkItems;

    private String content;
}