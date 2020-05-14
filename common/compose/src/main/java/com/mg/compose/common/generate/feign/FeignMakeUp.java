package com.mg.compose.common.generate.feign;

import com.mg.common.iservice.ibasic.IMakeUpBase;

public class FeignMakeUp extends IMakeUpBase {
    public FeignMakeUp(String name, String[] methods, String sysName) {
        add(new CreateFeign(name,methods));
        add(new CreateFeignConstant(name,methods,sysName));
        add(new CreateFeignFallBack(name,methods));
    }
}
