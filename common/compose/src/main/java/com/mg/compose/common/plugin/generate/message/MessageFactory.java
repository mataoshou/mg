package com.mg.compose.common.plugin.generate.message;


import com.mg.common.plugin.igenerate.IFactory;

public class MessageFactory extends IFactory {

    public MessageFactory(String name) {
        super();
        addMakeUp(new MessageMakeUp(name));
    }
}
