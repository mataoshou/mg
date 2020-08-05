////package com.mg.node.db.sql.pojo;
//
//import com.mg.node.common.frame.mgmybatis.imp.IGeneralMapper;
//import org.apache.ibatis.annotations.Select;
//import com.mg.node.db.sql.pojo.MTdSysConfig;
//
//
//public interface MTdSysConfigIGeneralMapperMapper extends IGeneralMapper<MTdSysConfig> {
//
//    @org.apache.ibatis.annotations.InsertProvider(type=com.mg.node.common.frame.mgmybatis.produce.SqlFactory.class,method="insertBlog")
//    @org.apache.ibatis.annotations.Options(keyProperty="id",useGeneratedKeys=true,keyColumn="id")
//    long insertBySql( MTdSysConfig TemplateItem item);
//    @org.apache.ibatis.annotations.Select(value={"select * from m_td_sys_config ${where} ${order}"})
//    java.util.List<MTdSysConfig> listByWhere( @org.apache.ibatis.annotations.Param(value="where") String where, @org.apache.ibatis.annotations.Param(value="order") String order);
//    @org.apache.ibatis.annotations.Select(value={"select * from m_td_sys_config where id=#{id}"})
//    MTdSysConfig getById( long id);
//    @org.apache.ibatis.annotations.Delete(value={"delete from m_td_sys_config where id=#{id}"})
//    int deleteById( long id);
//    @org.apache.ibatis.annotations.Update(value={"update m_td_sys_config set ${column}=${value} ${where}"})
//    int updateSingleColumn( @org.apache.ibatis.annotations.Param(value="column") String column, @org.apache.ibatis.annotations.Param(value="value") String value, @org.apache.ibatis.annotations.Param(value="where") String where);
//    @org.apache.ibatis.annotations.Insert(value={"${sql}","$111"})
//    MTdSysConfig getBySql( @org.apache.ibatis.annotations.Param(value="sql") String sql);
//    @org.apache.ibatis.annotations.Delete(value={"delete from m_td_sys_config ${where}"})
//    int deleteByWhere( @org.apache.ibatis.annotations.Param(value="where") String where);
//    @org.apache.ibatis.annotations.Update(value={"${sql}"})
//    int updateBySql( @org.apache.ibatis.annotations.Param(value="sql") String sql);
//    @org.apache.ibatis.annotations.Update(value={"update m_td_sys_config ${set} ${where}"})
//    int updateByWhere( @org.apache.ibatis.annotations.Param(value="set") String set, @org.apache.ibatis.annotations.Param(value="where") String where);
//    @org.apache.ibatis.annotations.Delete(value={"${sql}"})
//    int deleteBySql( @org.apache.ibatis.annotations.Param(value="sql") String sql);
//    @org.apache.ibatis.annotations.Update(value={"update m_td_sys_config set ${column}=${value} where id=#{id}"})
//    int updateById( String column, String value, long id);
//    @org.apache.ibatis.annotations.Select(value={"${sql}"})
//    java.util.List<MTdSysConfig> listBySql( @org.apache.ibatis.annotations.Param(value="sql") String sql);
//
//}