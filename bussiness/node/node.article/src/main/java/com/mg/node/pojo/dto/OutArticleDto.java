package com.mg.node.pojo.dto;

import com.mg.node.common.plugin.mybatis.annotations.Column;
import lombok.Data;

import java.util.Date;

@Data
public class OutArticleDto {

    private Long id;

    private String title;

    private String thumb;

    private Date timeCreated;

    private String author;

    private Integer showIndex;

    private String tags;

    private String ulr;

    private String content;

    private String linkItems;
}
