package com.mg.node.common.generate.cache;


import com.mg.common.iservice.ibasic.IMakeUpBase;

public class CacheMakeUp extends IMakeUpBase {
    public CacheMakeUp(String name, Class pojoClass, Class dtoClass) {
        add(new CreateCache(name,pojoClass,dtoClass));
    }
}
