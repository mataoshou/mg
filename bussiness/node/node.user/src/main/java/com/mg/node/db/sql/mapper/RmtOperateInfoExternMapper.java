package com.mg.node.db.sql.mapper; 

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.mg.node.db.sql.pojo.RmtOperateInfo;


public interface RmtOperateInfoExternMapper {
    List<RmtOperateInfo> list(@Param("where") String where,@Param("order") String order);
   
    RmtOperateInfo selectByName(String name);
   
    RmtOperateInfo get(@Param("where") String where);
   
    int insertByCustomId(RmtOperateInfo item);


}
