//package com.mg.node.db.sql.pojo.mapper;
//
//import com.mg.node.common.plugin.mybatis.imp.IGeneralMapper;
//import org.apache.ibatis.annotations.Result;
//import org.apache.ibatis.annotations.Select;
//import com.mg.node.db.sql.pojo.MTdSysConfig;
//
//
//public interface MTdSysConfigIGeneralMapperMapper extends IGeneralMapper<MTdSysConfig> {
//
//    @org.apache.ibatis.annotations.Update(value={"${sql}"})
//    int updateBySql( @org.apache.ibatis.annotations.Param(value="sql") String sql);
//    @org.apache.ibatis.annotations.Update(value={"update m_td_sys_config ${set} ${where}"})
//    int updateByWhere( @org.apache.ibatis.annotations.Param(value="set") String set, @org.apache.ibatis.annotations.Param(value="where") String where);
//    @org.apache.ibatis.annotations.Update(value={"update m_td_sys_config set ${column}=${value} where id=#{id}"})
//    int updateById( String column, String value, long id);
//    @org.apache.ibatis.annotations.Delete(value={"${sql}"})
//    int deleteBySql( @org.apache.ibatis.annotations.Param(value="sql") String sql);
//    @org.apache.ibatis.annotations.Delete(value={"delete from m_td_sys_config ${where}"})
//    int deleteByWhere( @org.apache.ibatis.annotations.Param(value="where") String where);
//    @org.apache.ibatis.annotations.Select(value={"${sql}"})
//    MTdSysConfig getBySql( @org.apache.ibatis.annotations.Param(value="sql") String sql);
//    @org.apache.ibatis.annotations.Select(value={"${sql}"})
//    @org.apache.ibatis.annotations.ResultMap(value={"GemeralMTdSysConfigResult"})
//    java.util.List<MTdSysConfig> listBySql( @org.apache.ibatis.annotations.Param(value="sql") String sql);
//    @org.apache.ibatis.annotations.Update(value={"update m_td_sys_config set ${column}=${value} ${where}"})
//    int updateSingleColumn( @org.apache.ibatis.annotations.Param(value="column") String column, @org.apache.ibatis.annotations.Param(value="value") String value, @org.apache.ibatis.annotations.Param(value="where") String where);
//    @org.apache.ibatis.annotations.Select(value={"select * from m_td_sys_config where ${column}=#{value}"})
//    MTdSysConfig getBySingleParam( @org.apache.ibatis.annotations.Param(value="column") String column, @org.apache.ibatis.annotations.Param(value="value") String value);
//    @org.apache.ibatis.annotations.Select(value={"select * from m_td_sys_config where id=#{id}"})
//    @org.apache.ibatis.annotations.Results(id = "GemeralMTdSysConfigResult",value = {@Result(column = "siteId",property = "siteId"),
//    })
//    MTdSysConfig getById( long id);
//    @org.apache.ibatis.annotations.Select(value={"select * from m_td_sys_config ${where} ${order}"})
//    java.util.List<MTdSysConfig> listByWhere( @org.apache.ibatis.annotations.Param(value="where") String where, @org.apache.ibatis.annotations.Param(value="order") String order);
//    @org.apache.ibatis.annotations.Delete(value={"delete from m_td_sys_config where id=#{id}"})
//    int deleteById( long id);
//    @org.apache.ibatis.annotations.UpdateProvider(type=com.mg.node.common.plugin.mybatis.produce.SqlFactory.class,method="updateItem")
//    int updateItem( @org.apache.ibatis.annotations.Param(value="pojoItem") MTdSysConfig item);
//    @org.apache.ibatis.annotations.InsertProvider(type=com.mg.node.common.plugin.mybatis.produce.SqlFactory.class,method="insertItem")
//    @org.apache.ibatis.annotations.Options(useGeneratedKeys=true,keyColumn="id",keyProperty="id")
//    int insertItem( @org.apache.ibatis.annotations.Param(value="pojoItem") MTdSysConfig item);
//
//}