package com.mg.node.db.sql.mapper; 

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.mg.node.db.sql.pojo.RmtPrivilegeInfo;


public interface RmtPrivilegeInfoExternMapper {
    List<RmtPrivilegeInfo> list(@Param("where") String where,@Param("order") String order);
   
    RmtPrivilegeInfo selectByName(String name);
   
    RmtPrivilegeInfo get(@Param("where") String where);
   
    int insertByCustomId(RmtPrivilegeInfo item);


}
