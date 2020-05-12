package com.mg.website.common.generate.action;

import com.mg.common.iservice.ibasic.IMakeUpBase;

public class ActionMakeUp extends IMakeUpBase {
    public ActionMakeUp(String name, Class toolClass, Class pojoClass, String[] methods) {
        add(new CreateAction(name,toolClass,pojoClass,methods));
        add(new CreateDTO(name,toolClass,pojoClass,methods));
    }
}
