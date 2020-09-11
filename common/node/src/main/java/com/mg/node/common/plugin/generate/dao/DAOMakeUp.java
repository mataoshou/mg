package com.mg.node.common.plugin.generate.dao;

import com.mg.common.plugin.igenerate.IMakeUpBase;

public class DAOMakeUp extends IMakeUpBase {

    public DAOMakeUp(String name, Class poCl, String[] methods) {
        add( new CreateDAO(name,methods,poCl));
    }

}
