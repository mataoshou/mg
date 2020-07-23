package com.mg.node.frame.template;

import org.apache.ibatis.annotations.Select;

public interface GeneralTemplate {

    @Select("${sql}")
    TemplateReturn getBySql(String sql);

    @Select("select * from ##tableName## where id=#{id}")
    TemplateReturn getById(String id);

}
