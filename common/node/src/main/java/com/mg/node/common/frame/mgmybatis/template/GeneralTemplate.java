package com.mg.node.common.frame.mgmybatis.template;

import org.apache.ibatis.annotations.*;

import java.util.List;

public interface GeneralTemplate {

    @Select("${sql}")
    TemplateReturn getBySql(@Param("sql") String sql);

    @Select("select * from $tableName$ where id=#{id}")
    TemplateReturn getById(long id);

    @Select("${sql}")
    List<TemplateReturn> listBySql(@Param("sql") String sql);

    @Select("select * from $tableName$ ${where} ${order}")
    List<TemplateReturn> listByWhere(@Param("where") String where,@Param("order") String order);

    @Insert("${sql}")
    TemplateReturn insertBySql(@Param("sql") String sql);

    @Update("${sql}")
    TemplateReturn updateBySql(@Param("sql") String sql);

    @Update("update $tableName$ ${set} ${where}")
    TemplateReturn updateByWhere(@Param("set") String set,@Param("where") String where);

    @Update("update $tableName$ set ${column}=${value} ${where}")
    TemplateReturn updateSingleColumn(@Param("column") String column,@Param("value") String value,@Param("where") String where);

    @Update("update $tableName$ set ${column}=${value} where id=#{id}")
    TemplateReturn updateById(String column,String value,long id);


    @Delete("${sql}")
    int deleteBySql(@Param("sql") String sql);

    @Delete("delete from $tableName$ ${where}")
    int deleteByWhere(@Param("where") String where);

    @Delete("delete from $tableName$ where id=#{id}")
    int deleteById(long id);

}
