package com.mg.node.db.sql.mapper; 

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.mg.node.db.sql.pojo.RmtTenantExtendInfo;


public interface RmtTenantExtendInfoExternMapper {
    List<RmtTenantExtendInfo> list(@Param("where") String where,@Param("order") String order);
   
    RmtTenantExtendInfo selectByName(String name);
   
    RmtTenantExtendInfo get(@Param("where") String where);
   
    int insertByCustomId(RmtTenantExtendInfo item);


}
