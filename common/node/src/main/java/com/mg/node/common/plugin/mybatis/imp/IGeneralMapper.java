package com.mg.node.common.plugin.mybatis.imp;

import java.util.List;

public interface IGeneralMapper<T> {

    T getBySql(String sql);

    T getById(long id);

    T getBySingleParam(String column,String value);

    List<T> listBySql(String sql);

    List<T> listByWhere(String where,String order);

    int insertItem(T item);

    int updateBySql(String sql);

    int updateByWhere(String set,String where);

    int updateItem(T item);

    int updateSingleColumn(String column,String value,String where);

    int updateById(String column,String value,long id);

    int deleteBySql(String sql);

    int deleteByWhere(String where);

    int deleteById(long id);
}
