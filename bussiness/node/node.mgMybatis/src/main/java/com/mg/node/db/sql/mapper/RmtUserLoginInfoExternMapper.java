package com.mg.node.db.sql.mapper; 

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.mg.node.db.sql.pojo.RmtUserLoginInfo;


public interface RmtUserLoginInfoExternMapper {
    List<RmtUserLoginInfo> list(@Param("where") String where,@Param("order") String order);
   
    RmtUserLoginInfo selectByName(String name);
   
    RmtUserLoginInfo get(@Param("where") String where);
   
    int insertByCustomId(RmtUserLoginInfo item);


}
