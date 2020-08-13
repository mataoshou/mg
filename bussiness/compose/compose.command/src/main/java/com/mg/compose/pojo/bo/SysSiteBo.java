package com.mg.compose.pojo.bo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysSiteBo {

    private Long id;

    private String sitename;

    private String password;

    private String displayname;

    private Integer sitetype;
}
