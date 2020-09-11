package com.mg.node.common.plugin.generate.dao;

import com.mg.common.plugin.igenerate.IFactory;

public class DAOFactory extends IFactory {
    public DAOFactory(String name, Class poCl, String[] methods) {
        addMakeUp(new DAOMakeUp(name,poCl,methods));
    }
}
