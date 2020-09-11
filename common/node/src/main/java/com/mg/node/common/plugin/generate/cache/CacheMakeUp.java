package com.mg.node.common.plugin.generate.cache;


import com.mg.common.plugin.igenerate.IMakeUpBase;

public class CacheMakeUp extends IMakeUpBase {
    public CacheMakeUp(String name, Class pojoClass, Class dtoClass) {
        add(new CreateCache(name,pojoClass,dtoClass));
    }
}
