package com.mg.node.db.sql.mapper; 

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.mg.node.db.sql.pojo.RmtOperateGroupInfo;


public interface RmtOperateGroupInfoExternMapper {
    List<RmtOperateGroupInfo> list(@Param("where") String where,@Param("order") String order);
   
    RmtOperateGroupInfo selectByName(String name);
   
    RmtOperateGroupInfo get(@Param("where") String where);
   
    int insertByCustomId(RmtOperateGroupInfo item);


}
