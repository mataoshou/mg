package com.mg.compose.common.plugin.generate.message;

import com.mg.common.plugin.igenerate.IMakeUpBase;

public class MessageMakeUp extends IMakeUpBase {
    public MessageMakeUp(String name) {
        super();

        add(new CreateMessageClient(name));
        add(new CreateMessageService(name));

    }
}
