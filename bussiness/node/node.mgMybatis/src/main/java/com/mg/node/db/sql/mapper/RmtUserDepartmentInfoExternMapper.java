package com.mg.node.db.sql.mapper; 

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.mg.node.db.sql.pojo.RmtUserDepartmentInfo;


public interface RmtUserDepartmentInfoExternMapper {
    List<RmtUserDepartmentInfo> list(@Param("where") String where,@Param("order") String order);
   
    RmtUserDepartmentInfo selectByName(String name);
   
    RmtUserDepartmentInfo get(@Param("where") String where);
   
    int insertByCustomId(RmtUserDepartmentInfo item);


}
