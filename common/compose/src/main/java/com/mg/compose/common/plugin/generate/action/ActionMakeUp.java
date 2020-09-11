package com.mg.compose.common.plugin.generate.action;

import com.mg.common.plugin.igenerate.IMakeUpBase;

public class ActionMakeUp extends IMakeUpBase {
    public ActionMakeUp(String name,
                        Class boVo,
                        Class inDto, Class outDto,
                        String[] methods) {
        add(new CreateAction(name,inDto,outDto,methods));
        add(new CreateActionConstant(name,methods));
        add(new CreateRepository(name,inDto,outDto,methods));
    }
}
