package com.mg.node.common.generate.cache;

import com.mg.common.iservice.ibasic.IFactory;
import com.mg.node.common.generate.action.ActionMakeUp;

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
