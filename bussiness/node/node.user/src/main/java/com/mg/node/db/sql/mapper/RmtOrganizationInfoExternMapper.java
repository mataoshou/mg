package com.mg.node.db.sql.mapper; 

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.mg.node.db.sql.pojo.RmtOrganizationInfo;


public interface RmtOrganizationInfoExternMapper {
    List<RmtOrganizationInfo> list(@Param("where") String where,@Param("order") String order);
   
    RmtOrganizationInfo selectByName(String name);
   
    RmtOrganizationInfo get(@Param("where") String where);
   
    int insertByCustomId(RmtOrganizationInfo item);


}
