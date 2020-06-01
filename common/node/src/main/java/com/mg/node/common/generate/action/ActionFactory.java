package com.mg.node.common.generate.action;


import com.mg.common.iservice.ibasic.IFactory;
import com.mg.node.common.action.sys.SysItem;

public class ActionFactory extends IFactory {
    public ActionFactory(SysItem item) {
        try {
            addMakeUp(new ActionMakeUp(item.getName(),
                    Class.forName(item.getInDtoName()),
                    Class.forName(item.getOutDtoName()),
                    Class.forName(item.getPoName()),
                    item.getMethods()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
