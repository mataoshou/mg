package com.mg.node.common.frame.mgmybatis.imp;

import com.mg.node.common.frame.mgmybatis.template.TemplateReturn;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IGeneralMapper<T> {

    T getBySql(String sql);

    T getById(long id);

    List<T> listBySql(String sql);

    List<T> listByWhere(String where,String order);

    long insertBySql(String sql);

    int updateBySql(String sql);

    int updateByWhere(String set,String where);

    int updateSingleColumn(String column,String value,String where);

    int updateById(String column,String value,long id);

    int deleteBySql(String sql);

    int deleteByWhere(String where);

    int deleteById(long id);
}
