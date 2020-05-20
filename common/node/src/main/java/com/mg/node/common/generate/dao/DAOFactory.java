package com.mg.node.common.generate.dao;

import com.mg.common.iservice.ibasic.IFactory;

public class DAOFactory extends IFactory {
    public DAOFactory(String name, Class poCl, String[] methods) {
        addMakeUp(new DAOMakeUp(name,poCl,methods));
    }
}
