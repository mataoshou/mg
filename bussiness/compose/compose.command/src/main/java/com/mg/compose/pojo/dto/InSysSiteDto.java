package com.mg.compose.pojo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InSysSiteDto {
    private Long id;

    private String sitename;

    private String password;

    private String displayname;

    private Integer sitetype;
}
