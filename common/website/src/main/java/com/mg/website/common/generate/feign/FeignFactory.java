package com.mg.website.common.generate.feign;

import com.mg.common.iservice.ibasic.IFactory;
import com.mg.website.common.action.sys.SysItem;

public class FeignFactory extends IFactory {
    public FeignFactory(SysItem item) {
        try {
            addMakeUp(new FeignMakeUp(item.getName(),
                    Class.forName(item.getInDtoName()),
                    Class.forName(item.getOutDtoName()),
                    item.getMethods(),item.getSysName()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
