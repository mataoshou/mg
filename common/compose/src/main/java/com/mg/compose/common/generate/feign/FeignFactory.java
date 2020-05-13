package com.mg.compose.common.generate.feign;

import com.mg.common.iservice.ibasic.IFactory;

public class FeignFactory extends IFactory {
    public FeignFactory(String name, String[] methods, String sysName) {
        addMakeUp(new FeignMakeUp(name,methods,sysName));
    }
}
