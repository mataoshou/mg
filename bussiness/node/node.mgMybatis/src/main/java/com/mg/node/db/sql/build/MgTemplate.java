//package com.mg.node.db.sql.build;
//
//import com.mg.node.db.sql.pojo.RmtActiorInfo;
//import com.mg.node.db.sql.pojo.RmtUserInfo;
//import org.apache.ibatis.annotations.Param;
//import org.apache.ibatis.annotations.Select;
//
//public interface MgTemplate extends ITemplate{
//
//    @Select("select * from rmt_actior_info where id=#{id}")
//    RmtActiorInfo getById(@Param("id") String id);
//
//    @Select("${sql}")
//    RmtActiorInfo getBySql(@Param("sql") String id);
//
//}
//
//
////public interface UserTemplate extends ITemplate<RmtUserInfo>{
////
////    @Select("select * from rmt_actior_info where id=#{id}")
////    RmtUserInfo getById(@Param("id") String id);
////
////    @Select("${sql}")
////    RmtUserInfo getBySql(@Param("sql") String id);
////
////}
