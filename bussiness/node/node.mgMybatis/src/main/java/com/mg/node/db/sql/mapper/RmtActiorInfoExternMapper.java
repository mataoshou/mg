package com.mg.node.db.sql.mapper; 

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.mg.node.db.sql.pojo.RmtActiorInfo;


public interface RmtActiorInfoExternMapper {
    List<RmtActiorInfo> list(@Param("where") String where,@Param("order") String order);
   
    RmtActiorInfo selectByName(String name);
   
    RmtActiorInfo get(@Param("where") String where);
   
    int insertByCustomId(RmtActiorInfo item);


}
