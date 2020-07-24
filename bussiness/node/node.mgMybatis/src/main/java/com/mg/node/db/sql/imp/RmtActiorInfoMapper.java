package com.mg.node.db.sql.imp;

import com.mg.node.frame.imp.IGeneralMapper;
import org.apache.ibatis.annotations.Select;
import com.mg.node.db.sql.pojo.RmtActiorInfo;


public interface RmtActiorInfoMapper extends IGeneralMapper {

    @org.apache.ibatis.annotations.Select(value="select * from rmt_actior_info where id=#{id}")
    RmtActiorInfo getById(String id);
    @org.apache.ibatis.annotations.Select(value="${sql}")
    RmtActiorInfo getBySql(String sql);

}