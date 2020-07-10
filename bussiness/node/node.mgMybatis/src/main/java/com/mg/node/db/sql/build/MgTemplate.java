package com.mg.node.db.sql.build;

import com.mg.node.db.sql.mapper.RmtActiorInfoBaseMapper;
import com.mg.node.db.sql.pojo.RmtActiorInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface MgTemplate extends ITemplate{

    @Select("select * from rmt_actior_info where id=#{id}")
    RmtActiorInfo getById(@Param("id") String id);

    @Select("${sql}")
    RmtActiorInfo getBySql(@Param("sql") String id);

}
