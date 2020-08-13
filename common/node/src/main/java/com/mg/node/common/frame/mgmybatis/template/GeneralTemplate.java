package com.mg.node.common.frame.mgmybatis.template;

import com.mg.node.common.frame.mgmybatis.produce.SqlFactory;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface GeneralTemplate {

    @Select("${sql}")
    TemplateItem getBySql(@Param("sql") String sql);

    @Select("select * from $tableName$ where id=#{id}")
    TemplateItem getById(long id);

    @Select("select * from $tableName$ where ${column}=#{value}")
    TemplateItem getBySingleParam(@Param("column")String column,@Param("value")String value);

    @Select("${sql}")
    List<TemplateItem> listBySql(@Param("sql") String sql);

//    @SelectProvider(type = SqlFactory.class,method = "selectItem")
//    List<TemplateItem> listByWhere(@Param("params") Map<String,Object> params,@Param("item") Class itemClass);

    @Select("select * from $tableName$ ${where} ${order}")
    List<TemplateItem> listByWhere(@Param("where") String where, @Param("order") String order);

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


    @Delete("${sql}")
    int deleteBySql(@Param("sql") String sql);

    @Delete("delete from $tableName$ ${where}")
    int deleteByWhere(@Param("where") String where);

    @Delete("delete from $tableName$ where id=#{id}")
    int deleteById(long id);

}
