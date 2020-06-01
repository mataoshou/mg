package com.mg.node.common.generate.action;

import com.mg.common.iservice.ibasic.IMakeUpBase;

public class ActionMakeUp extends IMakeUpBase {
    public ActionMakeUp(String name,
                        Class inDto, Class outDto,Class poDto,
                        String[] methods) {
        add(new CreateAction(name,inDto,outDto,methods));
        add(new CreateActionConstant(name,methods));
        add(new CreateRepository(name,inDto,outDto,poDto,methods));
    }
}
