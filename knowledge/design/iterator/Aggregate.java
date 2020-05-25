package com.mg.knowledge.design.iterator;

public interface Aggregate {

    void add(Object object);

    void remove(Object object);

    Iterator iterator();


}
