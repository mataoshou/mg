package com.mg.website.uauth.common.generate.action;


import com.mg.common.iservice.ibasic.IFactory;

public class ActionFactory extends IFactory {
    public ActionFactory(String name, Class toolClass, Class pojoClass, String[] methods) {
        addMakeUp(new ActionMakeUp(name,toolClass,pojoClass,methods));
    }
}
