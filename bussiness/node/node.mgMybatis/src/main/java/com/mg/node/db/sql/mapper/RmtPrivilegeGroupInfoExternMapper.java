package com.mg.node.db.sql.mapper; 

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.mg.node.db.sql.pojo.RmtPrivilegeGroupInfo;


public interface RmtPrivilegeGroupInfoExternMapper {
    List<RmtPrivilegeGroupInfo> list(@Param("where") String where,@Param("order") String order);
   
    RmtPrivilegeGroupInfo selectByName(String name);
   
    RmtPrivilegeGroupInfo get(@Param("where") String where);
   
    int insertByCustomId(RmtPrivilegeGroupInfo item);


}
