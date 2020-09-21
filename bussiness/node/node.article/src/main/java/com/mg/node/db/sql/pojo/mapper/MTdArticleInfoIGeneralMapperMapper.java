//package com.mg.node.db.sql.pojo.mapper;
//
//import com.mg.node.common.plugin.mybatis.imp.IGeneralMapper;
//import org.apache.ibatis.annotations.Select;
//import com.mg.node.db.sql.pojo.MTdArticleInfo;
//
//
//public interface MTdArticleInfoIGeneralMapperMapper extends IGeneralMapper<MTdArticleInfo> {
//
//    @org.apache.ibatis.annotations.Select(value={"${sql}"})
//    java.util.Map getMap( @org.apache.ibatis.annotations.Param(value="sql") String sql);
//    @org.apache.ibatis.annotations.Select(value={"select * from m_td_article_info where id=#{id}"})
//    @org.apache.ibatis.annotations.Results(id = "GeneralMTdArticleInfoResult" ,value = {@org.apache.ibatis.annotations.Result(column = "id",property = "id" ,id=true),
//            @org.apache.ibatis.annotations.Result(column = "title",property = "title"),
//            @org.apache.ibatis.annotations.Result(column = "thumb",property = "thumb"),
//            @org.apache.ibatis.annotations.Result(column = "time_created",property = "timeCreated"),
//            @org.apache.ibatis.annotations.Result(column = "time_modefied",property = "timeModefied"),
//            @org.apache.ibatis.annotations.Result(column = "author",property = "author"),
//            @org.apache.ibatis.annotations.Result(column = "show_index",property = "showIndex"),
//            @org.apache.ibatis.annotations.Result(column = "tags",property = "tags"),
//            @org.apache.ibatis.annotations.Result(column = "ulr",property = "ulr"),
//    })
//    MTdArticleInfo getById( long id);
//    @org.apache.ibatis.annotations.InsertProvider(type=com.mg.node.common.plugin.mybatis.produce.SqlFactory.class,method="insertItem")
//    @org.apache.ibatis.annotations.Options(useGeneratedKeys=true,keyProperty="id",keyColumn="id")
//    int insertItem( @org.apache.ibatis.annotations.Param(value="pojoItem") MTdArticleInfo item);
//    @org.apache.ibatis.annotations.Select(value={"select * from m_td_article_info ${where} ${order}"})
//    @org.apache.ibatis.annotations.ResultMap(value={"GeneralMTdArticleInfoResult"})
//    java.util.List<MTdArticleInfo> listByWhere( @org.apache.ibatis.annotations.Param(value="where") String where, @org.apache.ibatis.annotations.Param(value="order") String order);
//    @org.apache.ibatis.annotations.Delete(value={"delete from m_td_article_info where id=#{id}"})
//    int deleteById( long id);
//    @org.apache.ibatis.annotations.UpdateProvider(type=com.mg.node.common.plugin.mybatis.produce.SqlFactory.class,method="updateItem")
//    int updateItem( @org.apache.ibatis.annotations.Param(value="pojoItem") MTdArticleInfo item);
//    @org.apache.ibatis.annotations.Update(value={"update m_td_article_info set ${column}=${value} ${where}"})
//    int updateSingleColumn( @org.apache.ibatis.annotations.Param(value="column") String column, @org.apache.ibatis.annotations.Param(value="value") String value, @org.apache.ibatis.annotations.Param(value="where") String where);
//    @org.apache.ibatis.annotations.Delete(value={"${sql}"})
//    int deleteBySql( @org.apache.ibatis.annotations.Param(value="sql") String sql);
//    @org.apache.ibatis.annotations.Update(value={"${sql}"})
//    int updateBySql( @org.apache.ibatis.annotations.Param(value="sql") String sql);
//    @org.apache.ibatis.annotations.Select(value={"select * from m_td_article_info ${where} ${order}"})
//    com.github.pagehelper.Page<MTdArticleInfo> listByPage( @org.apache.ibatis.annotations.Param(value="where") String where, @org.apache.ibatis.annotations.Param(value="order") String order);
//    @org.apache.ibatis.annotations.Update(value={"update m_td_article_info ${set} ${where}"})
//    int updateByWhere( @org.apache.ibatis.annotations.Param(value="set") String set, @org.apache.ibatis.annotations.Param(value="where") String where);
//    @org.apache.ibatis.annotations.Select(value={"${sql}"})
//    MTdArticleInfo getBySql( @org.apache.ibatis.annotations.Param(value="sql") String sql);
//    @org.apache.ibatis.annotations.Select(value={"${sql}"})
//    @org.apache.ibatis.annotations.ResultMap(value={"GeneralMTdArticleInfoResult"})
//    java.util.List<MTdArticleInfo> listBySql( @org.apache.ibatis.annotations.Param(value="sql") String sql);
//    @org.apache.ibatis.annotations.Delete(value={"delete from m_td_article_info ${where}"})
//    int deleteByWhere( @org.apache.ibatis.annotations.Param(value="where") String where);
//    @org.apache.ibatis.annotations.Select(value={"select * from m_td_article_info where ${column}=#{value}"})
//    @org.apache.ibatis.annotations.ResultMap(value={"GeneralMTdArticleInfoResult"})
//    MTdArticleInfo getBySingleParam( @org.apache.ibatis.annotations.Param(value="column") String column, @org.apache.ibatis.annotations.Param(value="value") String value);
//    @org.apache.ibatis.annotations.Update(value={"update m_td_article_info set ${column}=${value} where id=#{id}"})
//    int updateById( String column, String value, long id);
//
//}