package com.mg.node.db.sql.mapper; 

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.mg.node.db.sql.pojo.RmtOrganizationChartInfo;


public interface RmtOrganizationChartInfoExternMapper {
    List<RmtOrganizationChartInfo> list(@Param("where") String where,@Param("order") String order);
   
    RmtOrganizationChartInfo selectByName(String name);
   
    RmtOrganizationChartInfo get(@Param("where") String where);
   
    int insertByCustomId(RmtOrganizationChartInfo item);


}
