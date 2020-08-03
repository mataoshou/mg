package com.mg.node.pojo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OutSysSiteDto {
    private Long id;

    private String sitename;

    private String password;

    private String displayname;

    private Integer sitetype;
}
