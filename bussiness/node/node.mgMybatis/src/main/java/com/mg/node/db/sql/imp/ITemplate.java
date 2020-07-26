package com.mg.node.db.sql.imp;

public interface ITemplate<T> {

    T getBySql(String sql);
}
