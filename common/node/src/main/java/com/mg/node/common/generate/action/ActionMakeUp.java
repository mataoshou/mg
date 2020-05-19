package com.mg.node.common.generate.action;

import com.mg.common.iservice.ibasic.IMakeUpBase;
import com.mg.node.common.generate.action.CreateAction;
import com.mg.node.common.generate.action.CreateActionConstant;
import com.mg.node.common.generate.action.CreateRepository;

public class ActionMakeUp extends IMakeUpBase {
    public ActionMakeUp(String name,
                        Class inVo, Class outVo,
                        Class inDto, Class outDto,
                        String[] methods) {
        add(new CreateAction(name,inVo,outVo,inDto,outDto,methods));
        add(new CreateActionConstant(name,methods));
        add(new CreateRepository(name,inDto,outDto,methods));
    }
}
