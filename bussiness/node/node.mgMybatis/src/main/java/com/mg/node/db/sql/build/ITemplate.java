package com.mg.node.db.sql.build;

import com.mg.node.db.sql.pojo.RmtActiorInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ITemplate {
    RmtActiorInfo getById(String id);

    RmtActiorInfo getBySql(String id);
}
