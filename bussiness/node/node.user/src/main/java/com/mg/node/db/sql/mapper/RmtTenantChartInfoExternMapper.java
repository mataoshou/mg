package com.mg.node.db.sql.mapper; 

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.mg.node.db.sql.pojo.RmtTenantChartInfo;


public interface RmtTenantChartInfoExternMapper {
    List<RmtTenantChartInfo> list(@Param("where") String where,@Param("order") String order);
   
    RmtTenantChartInfo selectByName(String name);
   
    RmtTenantChartInfo get(@Param("where") String where);
   
    int insertByCustomId(RmtTenantChartInfo item);


}
