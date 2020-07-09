package com.mg.node.db.sql.mapper; 

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.mg.node.db.sql.pojo.RmtDepartmentChartInfo;


public interface RmtDepartmentChartInfoExternMapper {
    List<RmtDepartmentChartInfo> list(@Param("where") String where,@Param("order") String order);
   
    RmtDepartmentChartInfo selectByName(String name);
   
    RmtDepartmentChartInfo get(@Param("where") String where);
   
    int insertByCustomId(RmtDepartmentChartInfo item);


}
