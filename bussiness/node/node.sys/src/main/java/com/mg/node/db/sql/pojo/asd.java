//package com.mg.node.db.sql.pojo.mapper;
//
//import com.mg.node.common.plugin.mybatis.imp.IGeneralMapper;
//import org.apache.ibatis.annotations.Select;
//import com.mg.node.db.sql.pojo.MTdSysSite;
//
//
//public interface MTdSysSiteIGeneralMapperMapper extends IGeneralMapper<MTdSysSite> {
//
//    @org.apache.ibatis.annotations.Select(value={"${sql}"})
//    java.util.Map getMap( @org.apache.ibatis.annotations.Param(value="sql") String sql);
//    @org.apache.ibatis.annotations.Select(value={"select * from m_td_sys_site ${where} ${order}"})
//    @org.apache.ibatis.annotations.ResultMap(value={"GeneralMTdSysSiteResult"})
//    java.util.List<MTdSysSite> listByWhere( @org.apache.ibatis.annotations.Param(value="where") String where, @org.apache.ibatis.annotations.Param(value="order") String order);
//    @org.apache.ibatis.annotations.Delete(value={"delete from m_td_sys_site where id=#{id}"})
//    int deleteById( long id);
//    @org.apache.ibatis.annotations.Select(value={"select * from m_td_sys_site where ${column}=#{value}"})
//    @org.apache.ibatis.annotations.ResultMap(value={"GeneralMTdSysSiteResult"})
//    MTdSysSite getBySingleParam( @org.apache.ibatis.annotations.Param(value="column") String column, @org.apache.ibatis.annotations.Param(value="value") String value);
//    @org.apache.ibatis.annotations.Select(value={"select * from m_td_sys_site where id=#{id}"})
//    @org.apache.ibatis.annotations.Results(id = "GeneralMTdSysSiteResult" ,
//            value = {
//            @org.apache.ibatis.annotations.Result(column = "siteId",property = "siteid"),
//            @org.apache.ibatis.annotations.Result(column = "siteName",property = "sitename"),
//            @org.apache.ibatis.annotations.Result(column = "password",property = "password"),
//            @org.apache.ibatis.annotations.Result(column = "displayName",property = "displayname"),
//            @org.apache.ibatis.annotations.Result(column = "siteType",property = "sitetype"),
//            @org.apache.ibatis.annotations.Result(column = "timeCreated",property = "timecreated"),
//    })
//    MTdSysSite getById( long id);
//    @org.apache.ibatis.annotations.InsertProvider(type=com.mg.node.common.plugin.mybatis.produce.SqlFactory.class,method="insertItem")
//    @org.apache.ibatis.annotations.Options(useGeneratedKeys=true,keyProperty="id",keyColumn="id")
//    int insertItem( @org.apache.ibatis.annotations.Param(value="pojoItem") MTdSysSite item);
//    @org.apache.ibatis.annotations.UpdateProvider(type=com.mg.node.common.plugin.mybatis.produce.SqlFactory.class,method="updateItem")
//    int updateItem( @org.apache.ibatis.annotations.Param(value="pojoItem") MTdSysSite item);
//    @org.apache.ibatis.annotations.Select(value={"select * from m_td_sys_site ${where} ${order}"})
//    com.github.pagehelper.Page<MTdSysSite> listByPage( @org.apache.ibatis.annotations.Param(value="where") String where, @org.apache.ibatis.annotations.Param(value="order") String order);
//    @org.apache.ibatis.annotations.Update(value={"update m_td_sys_site set ${column}=${value} ${where}"})
//    int updateSingleColumn( @org.apache.ibatis.annotations.Param(value="column") String column, @org.apache.ibatis.annotations.Param(value="value") String value, @org.apache.ibatis.annotations.Param(value="where") String where);
//    @org.apache.ibatis.annotations.Select(value={"${sql}"})
//    @org.apache.ibatis.annotations.ResultMap(value={"GeneralMTdSysSiteResult"})
//    java.util.List<MTdSysSite> listBySql( @org.apache.ibatis.annotations.Param(value="sql") String sql);
//    @org.apache.ibatis.annotations.Delete(value={"${sql}"})
//    int deleteBySql( @org.apache.ibatis.annotations.Param(value="sql") String sql);
//    @org.apache.ibatis.annotations.Update(value={"${sql}"})
//    int updateBySql( @org.apache.ibatis.annotations.Param(value="sql") String sql);
//    @org.apache.ibatis.annotations.Update(value={"update m_td_sys_site ${set} ${where}"})
//    int updateByWhere( @org.apache.ibatis.annotations.Param(value="set") String set, @org.apache.ibatis.annotations.Param(value="where") String where);
//    @org.apache.ibatis.annotations.Delete(value={"delete from m_td_sys_site ${where}"})
//    int deleteByWhere( @org.apache.ibatis.annotations.Param(value="where") String where);
//    @org.apache.ibatis.annotations.Update(value={"update m_td_sys_site set ${column}=${value} where id=#{id}"})
//    int updateById( String column, String value, long id);
//    @org.apache.ibatis.annotations.Select(value={"${sql}"})
//    MTdSysSite getBySql( @org.apache.ibatis.annotations.Param(value="sql") String sql);
//
//}