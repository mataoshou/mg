package com.mg.node.common.frame.mgmybatis.template;

import org.apache.ibatis.annotations.*;

import java.util.List;

public interface GeneralTemplate {

    @Insert(value = {"${sql}","$111"})
    TemplateReturn getBySql(@Param("sql") String sql);

    @Select("select * from $tableName$ where id=#{id}")
    TemplateReturn getById(long id);

    @Select("${sql}")
    List<TemplateReturn> listBySql(@Param("sql") String sql);

    @Select("select * from $tableName$ ${where} ${order}")
    List<TemplateReturn> listByWhere(@Param("where") String where,@Param("order") String order);

    @Insert("${sql}")
    @SelectKey(statement="select last_insert_id()", keyProperty="id", before=false, resultType=long.class)
    long insertBySql(@Param("sql") String sql);

    @Update("${sql}")
    int updateBySql(@Param("sql") String sql);

    @Update("update $tableName$ ${set} ${where}")
    int updateByWhere(@Param("set") String set,@Param("where") String where);

    @Update("update $tableName$ set ${column}=${value} ${where}")
    int updateSingleColumn(@Param("column") String column,@Param("value") String value,@Param("where") String where);

    @Update("update $tableName$ set ${column}=${value} where id=#{id}")
    int updateById(String column,String value,long id);


    @Delete("${sql}")
    int deleteBySql(@Param("sql") String sql);

    @Delete("delete from $tableName$ ${where}")
    int deleteByWhere(@Param("where") String where);

    @Delete("delete from $tableName$ where id=#{id}")
    int deleteById(long id);

}
