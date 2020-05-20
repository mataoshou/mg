package com.mg.node.common.generate.dao;

import com.mg.common.iservice.ibasic.IMakeUpBase;

public class DAOMakeUp extends IMakeUpBase {

    public DAOMakeUp(String name, Class poCl, String[] methods) {
        add( new CreateDAO(name,methods,poCl));
    }

}
