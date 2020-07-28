package com.mg.node.common.frame.mgmybatis.imp;

import java.util.List;

public interface IGeneralMapper<T> {

    T getBySql(String sql);

    T getById(long id);

    List<T> listItem(String sql);

}
