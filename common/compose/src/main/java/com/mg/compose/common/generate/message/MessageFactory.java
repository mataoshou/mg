package com.mg.compose.common.generate.message;


import com.mg.common.iservice.ibasic.IFactory;

public class MessageFactory extends IFactory {

    public MessageFactory(String name) {
        super();
        addMakeUp(new MessageMakeUp(name));
    }
}
