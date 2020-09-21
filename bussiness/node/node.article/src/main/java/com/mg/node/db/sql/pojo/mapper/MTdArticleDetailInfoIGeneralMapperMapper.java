//package com.mg.node.db.sql.pojo.mapper;
//
//import com.mg.node.common.plugin.mybatis.imp.IGeneralMapper;
//import org.apache.ibatis.annotations.Select;
//import com.mg.node.db.sql.pojo.MTdArticleDetailInfo;
//
//
//public interface MTdArticleDetailInfoIGeneralMapperMapper extends IGeneralMapper<MTdArticleDetailInfo> {
//
//    @org.apache.ibatis.annotations.Select(value={"${sql}"})
//    java.util.Map getMap( @org.apache.ibatis.annotations.Param(value="sql") String sql);
//    @org.apache.ibatis.annotations.Update(value={"update m_td_article_detail_info set ${column}=${value} ${where}"})
//    int updateSingleColumn( @org.apache.ibatis.annotations.Param(value="column") String column, @org.apache.ibatis.annotations.Param(value="value") String value, @org.apache.ibatis.annotations.Param(value="where") String where);
//    @org.apache.ibatis.annotations.Delete(value={"delete from m_td_article_detail_info where id=#{id}"})
//    int deleteById( long id);
//    @org.apache.ibatis.annotations.Select(value={"select * from m_td_article_detail_info ${where} ${order}"})
//    @org.apache.ibatis.annotations.ResultMap(value={"GeneralMTdArticleDetailInfoResult"})
//    java.util.List<MTdArticleDetailInfo> listByWhere( @org.apache.ibatis.annotations.Param(value="where") String where, @org.apache.ibatis.annotations.Param(value="order") String order);
//    @org.apache.ibatis.annotations.Select(value={"select * from m_td_article_detail_info where id=#{id}"})
//    @org.apache.ibatis.annotations.Results(id = "GeneralMTdArticleDetailInfoResult" ,value = {@org.apache.ibatis.annotations.Result(column = "id",property = "id" ,id=true),
//            @org.apache.ibatis.annotations.Result(column = "status",property = "status"),
//            @org.apache.ibatis.annotations.Result(column = "link_items",property = "linkItems"),
//            @org.apache.ibatis.annotations.Result(column = "content",property = "content"),
//    })
//    MTdArticleDetailInfo getById( long id);
//    @org.apache.ibatis.annotations.UpdateProvider(type=com.mg.node.common.plugin.mybatis.produce.SqlFactory.class,method="updateItem")
//    int updateItem( @org.apache.ibatis.annotations.Param(value="pojoItem") MTdArticleDetailInfo item);
//    @org.apache.ibatis.annotations.InsertProvider(type=com.mg.node.common.plugin.mybatis.produce.SqlFactory.class,method="insertItem")
//    @org.apache.ibatis.annotations.Options(keyColumn="id",useGeneratedKeys=true,keyProperty="id")
//    int insertItem( @org.apache.ibatis.annotations.Param(value="pojoItem") MTdArticleDetailInfo item);
//    @org.apache.ibatis.annotations.Update(value={"${sql}"})
//    int updateBySql( @org.apache.ibatis.annotations.Param(value="sql") String sql);
//    @org.apache.ibatis.annotations.Update(value={"update m_td_article_detail_info set ${column}=${value} where id=#{id}"})
//    int updateById( String column, String value, long id);
//    @org.apache.ibatis.annotations.Delete(value={"${sql}"})
//    int deleteBySql( @org.apache.ibatis.annotations.Param(value="sql") String sql);
//    @org.apache.ibatis.annotations.Delete(value={"delete from m_td_article_detail_info ${where}"})
//    int deleteByWhere( @org.apache.ibatis.annotations.Param(value="where") String where);
//    @org.apache.ibatis.annotations.Select(value={"${sql}"})
//    @org.apache.ibatis.annotations.ResultMap(value={"GeneralMTdArticleDetailInfoResult"})
//    java.util.List<MTdArticleDetailInfo> listBySql( @org.apache.ibatis.annotations.Param(value="sql") String sql);
//    @org.apache.ibatis.annotations.Select(value={"${sql}"})
//    MTdArticleDetailInfo getBySql( @org.apache.ibatis.annotations.Param(value="sql") String sql);
//    @org.apache.ibatis.annotations.Select(value={"select * from m_td_article_detail_info ${where} ${order}"})
//    com.github.pagehelper.Page<MTdArticleDetailInfo> listByPage( @org.apache.ibatis.annotations.Param(value="where") String where, @org.apache.ibatis.annotations.Param(value="order") String order);
//    @org.apache.ibatis.annotations.Select(value={"select * from m_td_article_detail_info where ${column}=#{value}"})
//    @org.apache.ibatis.annotations.ResultMap(value={"GeneralMTdArticleDetailInfoResult"})
//    MTdArticleDetailInfo getBySingleParam( @org.apache.ibatis.annotations.Param(value="column") String column, @org.apache.ibatis.annotations.Param(value="value") String value);
//    @org.apache.ibatis.annotations.Update(value={"update m_td_article_detail_info ${set} ${where}"})
//    int updateByWhere( @org.apache.ibatis.annotations.Param(value="set") String set, @org.apache.ibatis.annotations.Param(value="where") String where);
//
//}