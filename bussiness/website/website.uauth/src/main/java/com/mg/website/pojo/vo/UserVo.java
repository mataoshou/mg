package com.mg.website.pojo.vo;

import lombok.Data;
import org.dozer.Mapping;

@Data
public class UserVo {

    @Mapping("name")
    private String sname;
    @Mapping("id")
    private int sid;
}
