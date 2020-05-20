package com.mg.node.db.sql.mapper; 

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.mg.node.db.sql.pojo.RmtDepartmentInfo;


public interface RmtDepartmentInfoExternMapper {
    List<RmtDepartmentInfo> list(@Param("where") String where,@Param("order") String order);
   
    RmtDepartmentInfo selectByName(String name);
   
    RmtDepartmentInfo get(@Param("where") String where);
   
    int insertByCustomId(RmtDepartmentInfo item);


}
