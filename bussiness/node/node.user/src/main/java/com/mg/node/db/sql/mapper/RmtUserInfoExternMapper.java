package com.mg.node.db.sql.mapper; 

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.mg.node.db.sql.pojo.RmtUserInfo;


public interface RmtUserInfoExternMapper {
    List<RmtUserInfo> list(@Param("where") String where,@Param("order") String order);
   
    RmtUserInfo selectByName(String name);
   
    RmtUserInfo get(@Param("where") String where);
   
    int insertByCustomId(RmtUserInfo item);


}
