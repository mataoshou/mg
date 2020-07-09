package com.mg.node.db.sql.mapper; 

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.mg.node.db.sql.pojo.RmtDepartmentExtendInfo;


public interface RmtDepartmentExtendInfoExternMapper {
    List<RmtDepartmentExtendInfo> list(@Param("where") String where,@Param("order") String order);
   
    RmtDepartmentExtendInfo selectByName(String name);
   
    RmtDepartmentExtendInfo get(@Param("where") String where);
   
    int insertByCustomId(RmtDepartmentExtendInfo item);


}
