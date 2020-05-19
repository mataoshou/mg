package com.mg.node.common.generate.feign;

import com.mg.common.iservice.ibasic.IMakeUpBase;
import com.mg.node.common.generate.feign.CreateFeignConstant;
import com.mg.node.common.generate.feign.CreateFeignFallBack;

public class FeignMakeUp extends IMakeUpBase {
    public FeignMakeUp(String name,Class incl,Class outcl, String[] methods, String sysName) {
        add(new CreateFeign(name,methods,incl,outcl));
        add(new CreateFeignConstant(name,methods,sysName));
        add(new CreateFeignFallBack(name,methods,incl,outcl));
    }
}
