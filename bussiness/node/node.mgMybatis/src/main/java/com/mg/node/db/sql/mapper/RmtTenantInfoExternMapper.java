package com.mg.node.db.sql.mapper; 

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.mg.node.db.sql.pojo.RmtTenantInfo;


public interface RmtTenantInfoExternMapper {
    List<RmtTenantInfo> list(@Param("where") String where,@Param("order") String order);
   
    RmtTenantInfo selectByName(String name);
   
    RmtTenantInfo get(@Param("where") String where);
   
    int insertByCustomId(RmtTenantInfo item);


}
