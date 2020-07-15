package com.mg.node.db.sql.imp;

import com.mg.node.db.sql.pojo.RmtUserInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ITemplate<T> {

    T getBySql(String sql);
}
