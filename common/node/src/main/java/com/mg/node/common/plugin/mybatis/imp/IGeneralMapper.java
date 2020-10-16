package com.mg.node.common.plugin.mybatis.imp;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface IGeneralMapper<T> {

    T getBySql(String sql);

    T getById(long id);

    T getByStrId(String id);

    T getByParam(String column,String value);

    List<T> listBySql(String sql);

    List<T> listByWhere(String where,String order);

    Page<T> listByPage(String where, String order);

    Map getMap(String sql);

//    List listMap(String sql);

    int insertItem(T item);

    int updateBySql(String sql);

    int updateByWhere(String set,String where);

    int updateItem(T item);

    int updateColumn(String column,String value,String where);

    int updateById(String column,String value,long id);

    int deleteBySql(String sql);

    int deleteByWhere(String where);

    int deleteById(long id);
    int deleteByStrId(String id);
    int deleteByParam(String column,String value);
}
