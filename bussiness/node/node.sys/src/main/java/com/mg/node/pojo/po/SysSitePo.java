package com.mg.node.pojo.po;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SysSitePo {

    private Long id;

    private String sitename;

    private String password;

    private String displayname;

    private Integer sitetype;
}
