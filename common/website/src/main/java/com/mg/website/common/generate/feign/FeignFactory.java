package com.mg.website.common.generate.feign;

import com.mg.common.iservice.ibasic.IFactory;

public class FeignFactory extends IFactory {
    public FeignFactory(String name, String[] methods, String sysName) {
        super(name);
        addMakeUp(new FeignMakeUp(name,methods,sysName));
    }
}
