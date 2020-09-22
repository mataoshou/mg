package com.mg.node.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
public class InArticleDto {

    private Long id;

    private String title;

    private String author;

    private String content;

}
