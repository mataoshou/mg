package com.mg.node.db.sql.mapper; 

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.mg.node.db.sql.pojo.RmtOrganizationExtendInfo;


public interface RmtOrganizationExtendInfoExternMapper {
    List<RmtOrganizationExtendInfo> list(@Param("where") String where,@Param("order") String order);
   
    RmtOrganizationExtendInfo selectByName(String name);
   
    RmtOrganizationExtendInfo get(@Param("where") String where);
   
    int insertByCustomId(RmtOrganizationExtendInfo item);


}
