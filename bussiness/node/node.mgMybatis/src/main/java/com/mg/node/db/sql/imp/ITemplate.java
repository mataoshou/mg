package com.mg.node.db.sql.imp;

import com.mg.node.db.sql.pojo.RmtUserInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ITemplate<T> {
//    @Select("${sql}")
//    T getById(String id);

    //    @Select("${sql}")
    @Select("select * from rmt_user_info where id=#{id}")
    RmtUserInfo getBySql(@Param("id") String sql);
}
