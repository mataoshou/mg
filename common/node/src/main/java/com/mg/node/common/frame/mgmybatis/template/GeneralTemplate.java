package com.mg.node.common.frame.mgmybatis.template;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GeneralTemplate {

    @Select("${sql}")
    TemplateReturn getBySql(@Param("sql") String sql);

    @Select("select * from $tableName$ where id=#{id}")
    TemplateReturn getById(long id);


    @Select("${_parameter}")
    List<TemplateReturn> listItem(String sql);



}
