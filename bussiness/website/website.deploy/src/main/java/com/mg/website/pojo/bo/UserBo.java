package com.mg.website.pojo.bo;

import lombok.Data;
import org.dozer.Mapping;

@Data
public class UserBo {

    @Mapping("name")
    private String sname;
    @Mapping("id")
    private int sid;
}
