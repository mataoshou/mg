package com.mg.node.db.sql.build;

import com.mg.node.db.sql.pojo.RmtActiorInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IMgDao<T> {

    int deleteByPrimaryKey(String id);

    int insert(T item);

    int insertSelective(T item);

    RmtActiorInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(T item);

    int updateByPrimaryKeyWithBLOBs(T item);

    int updateByPrimaryKey(T item);

    List<T> list(@Param("where") String where, @Param("order") String order);

    T selectByName(String name);

    T getItem(@Param("where") String where);

    T getById(@Param("id") String id);

    int insertByCustomId(T item);

}
