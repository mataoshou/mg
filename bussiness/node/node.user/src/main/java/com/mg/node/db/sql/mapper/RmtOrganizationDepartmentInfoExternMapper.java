package com.mg.node.db.sql.mapper; 

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.mg.node.db.sql.pojo.RmtOrganizationDepartmentInfo;


public interface RmtOrganizationDepartmentInfoExternMapper {
    List<RmtOrganizationDepartmentInfo> list(@Param("where") String where,@Param("order") String order);
   
    RmtOrganizationDepartmentInfo selectByName(String name);
   
    RmtOrganizationDepartmentInfo get(@Param("where") String where);
   
    int insertByCustomId(RmtOrganizationDepartmentInfo item);


}
