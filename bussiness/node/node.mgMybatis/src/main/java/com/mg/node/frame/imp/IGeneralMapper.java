package com.mg.node.frame.imp;

import java.util.List;

public interface IGeneralMapper<T> {

    T getBySql(String sql);

    T getById(String id);

    List<T> list(String id);
}
