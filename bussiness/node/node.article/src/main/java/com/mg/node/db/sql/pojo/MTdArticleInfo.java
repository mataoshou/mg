package com.mg.node.db.sql.pojo;

import com.mg.node.common.plugin.mybatis.annotations.Column;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import com.mg.node.common.plugin.mybatis.annotations.Table;
import java.util.Date;
import lombok.Data;

@Data
@Table("m_td_article_info")
public class MTdArticleInfo {
    @PrimaryId
    private Long id;

    private String title;

    private String thumb;

    @Column(cloumn= "time_created")
    private Date timeCreated;

    @Column(cloumn= "time_modefied")
    private Date timeModefied;

    private String author;

    @Column(cloumn= "show_index")
    private Integer showIndex;

    private String tags;

    private String ulr;
}