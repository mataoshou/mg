package com.mg.compose.common.generate.message;

import com.mg.common.iservice.ibasic.ICreate;
import com.mg.common.unit.ClassUnit;
import com.mg.common.unit.MethodUnit;
import com.mg.common.util.StringUtil;
import com.mg.compose.common.constant.MessageConstant;

import java.io.IOException;

public class CreateMessageClient extends ICreate {

    public CreateMessageClient(String name) {
        super(name,  new String[]{
                "input","output"
        });
    }


    @Override
    protected void createPre(ClassUnit unit) throws IOException {

    }

    @Override
    protected void createPreEachMethod(MethodUnit unit) throws IOException {
        if(unit.getName().indexOf("input")>0) {
            unit.addTabLeftContent(String.format("String  INPUTNAME = \"%sMessageInput\";", StringUtil.firstUpper(this.getName())));
        }
        else {
            unit.addTabLeftContent(String.format("String  OUTPUTNAME = \"%sMessageOutput\";", StringUtil.firstUpper(this.getName())));
        }
    }

    @Override
    protected void createMethod(MethodUnit unit) throws IOException {
        unit.setType(2);
        if(unit.getName().indexOf("input")>0) {
            unit.addAnnotation("Input(INPUTNAME)");
            unit.addAnnotation("Override");
            unit.setReturnValue("SubscribableChannel");
        }
        else {
            unit.addAnnotation("Output(OUTPUTNAME)");
            unit.addAnnotation("Override");
            unit.setReturnValue("MessageChannel");
        }
    }

    @Override
    protected void classInit(ClassUnit unit) {
        unit.setType(2);
        unit.setBaseName("BaseMessage");
    }

    @Override
    protected String getPackageName() {
        return MessageConstant.MESSAGE_CLINET_PACKAGE;
    }

    @Override
    public String getClassName(String name) {
        return StringUtil.firstUpper(name) + "Client";
    }
}
