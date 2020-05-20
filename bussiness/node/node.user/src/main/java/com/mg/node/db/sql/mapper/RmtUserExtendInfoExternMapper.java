package com.mg.node.db.sql.mapper; 

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.mg.node.db.sql.pojo.RmtUserExtendInfo;


public interface RmtUserExtendInfoExternMapper {
    List<RmtUserExtendInfo> list(@Param("where") String where,@Param("order") String order);
   
    RmtUserExtendInfo selectByName(String name);
   
    RmtUserExtendInfo get(@Param("where") String where);
   
    int insertByCustomId(RmtUserExtendInfo item);


}
