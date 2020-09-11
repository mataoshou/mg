package com.mg.compose.common.plugin.generate.feign;

import com.mg.common.plugin.igenerate.IFactory;
import com.mg.compose.common.action.sys.SysItem;

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
