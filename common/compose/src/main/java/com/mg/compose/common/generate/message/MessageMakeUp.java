package com.mg.compose.common.generate.message;

import com.mg.common.iservice.ibasic.IMakeUpBase;

public class MessageMakeUp extends IMakeUpBase {
    public MessageMakeUp(String name) {
        super();

        add(new CreateMessageClient(name));
        add(new CreateMessageService(name));

    }
}
