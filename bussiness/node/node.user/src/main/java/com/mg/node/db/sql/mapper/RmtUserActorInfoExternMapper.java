package com.mg.node.db.sql.mapper; 

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.mg.node.db.sql.pojo.RmtUserActorInfo;


public interface RmtUserActorInfoExternMapper {
    List<RmtUserActorInfo> list(@Param("where") String where,@Param("order") String order);
   
    RmtUserActorInfo selectByName(String name);
   
    RmtUserActorInfo get(@Param("where") String where);
   
    int insertByCustomId(RmtUserActorInfo item);


}
