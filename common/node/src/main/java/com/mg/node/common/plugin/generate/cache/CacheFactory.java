package com.mg.node.common.plugin.generate.cache;

import com.mg.common.plugin.igenerate.IFactory;

public class CacheFactory extends IFactory {
    public CacheFactory(String name, String pojoClass, String dtoClass) {
        try {
            addMakeUp(new CacheMakeUp(name,
                    Class.forName(pojoClass),
                    Class.forName(dtoClass)));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



}
