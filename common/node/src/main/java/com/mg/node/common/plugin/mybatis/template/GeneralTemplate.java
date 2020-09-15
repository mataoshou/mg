package com.mg.node.common.plugin.mybatis.template;

import com.github.pagehelper.Page;
import com.mg.node.common.plugin.mybatis.produce.SqlFactory;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

public interface GeneralTemplate {

    ////////////////////////////////查询区域/////////////////////////////////////
    @Select("${sql}")
    TemplateItem getBySql(@Param("sql") String sql);

    @Select("select * from $tableName$ where $idName$=#{id}")
    @Results()
    TemplateItem getById(long id);

    @Select("select * from $tableName$ where ${column}=#{value}")
    @ResultMap("$ResultMapId$")
    TemplateItem getBySingleParam(@Param("column")String column,@Param("value")String value);

    @Select("${sql}")
    @ResultMap("$ResultMapId$")
    List<TemplateItem> listBySql(@Param("sql") String sql);

    @Select("select * from $tableName$ ${where} ${order}")
    @ResultMap("$ResultMapId$")
    List<TemplateItem> listByWhere(@Param("where") String where, @Param("order") String order);

    @Select("select * from $tableName$ ${where} ${order}")
    Page<TemplateItem> listByPage(@Param("where")String where, @Param("order")String order);

    @Select("${sql}")
    Map getMap(@Param("sql") String sql);


    //////////////////////////////// 插入更新区/////////////////////////////////////
    @InsertProvider(type = SqlFactory.class,method = "insertItem")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insertItem(@Param("pojoItem") TemplateItem item);

    @Update("${sql}")
    int updateBySql(@Param("sql") String sql);

    @Update("update $tableName$ ${set} ${where}")
    int updateByWhere(@Param("set") String set,@Param("where") String where);

    @Update("update $tableName$ set ${column}=${value} ${where}")
    int updateSingleColumn(@Param("column") String column,@Param("value") String value,@Param("where") String where);

    @Update("update $tableName$ set ${column}=${value} where id=#{id}")
    int updateById(String column,String value,long id);


    @UpdateProvider(type = SqlFactory.class,method = "updateItem")
    int updateItem(@Param("pojoItem") TemplateItem item);


    ////////////////////////////删除区/////////////////////////////////////

    @Delete("${sql}")
    int deleteBySql(@Param("sql") String sql);

    @Delete("delete from $tableName$ ${where}")
    int deleteByWhere(@Param("where") String where);

    @Delete("delete from $tableName$ where id=#{id}")
    int deleteById(long id);

}
