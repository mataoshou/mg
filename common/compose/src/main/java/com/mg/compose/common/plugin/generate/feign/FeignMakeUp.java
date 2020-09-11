package com.mg.compose.common.plugin.generate.feign;

import com.mg.common.plugin.igenerate.IMakeUpBase;

public class FeignMakeUp extends IMakeUpBase {
    public FeignMakeUp(String name,Class incl,Class outcl, String[] methods, String sysName) {
        add(new CreateFeign(name,methods,incl,outcl));
        add(new CreateFeignConstant(name,methods,sysName));
        add(new CreateFeignFallBack(name,methods,incl,outcl));
        add(new CreateFeignFallBackFactory(name));
    }
}
