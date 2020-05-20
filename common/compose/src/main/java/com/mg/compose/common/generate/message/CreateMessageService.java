package com.mg.compose.common.generate.message;

import com.mg.common.iservice.ibasic.ICreate;
import com.mg.common.unit.ClassUnit;
import com.mg.common.unit.MethodUnit;
import com.mg.common.util.StringUtil;
import com.mg.compose.common.constant.MessageConstant;

import java.io.IOException;

public class CreateMessageService extends ICreate {


    public CreateMessageService(String name) {
        super(name, new String[]{
                "receive"
        });
    }

    @Override
    protected void createPre(ClassUnit unit) throws IOException {

    }

    @Override
    protected void createPreEachMethod(MethodUnit munit) throws IOException {

    }

    @Override
    protected void createMethod(MethodUnit unit) throws IOException {
        unit.addAnnotation(String.format("StreamListener(%sMessageClient.INPUTNAME)",StringUtil.firstUpper(this.getName())));
        unit.addParam("String","message");
        unit.addTabContent("log.info(\"收到消息，请处理：\"+message);");
    }

    @Override
    protected void classInit(ClassUnit unit) {
        unit.addAnnotion("Component");
        unit.addAnnotion("Slf4j");
        unit.addAnnotion(String.format("EnableBinding(PrivilegeMessageClient.class)"));
        unit.addImport(new String[]{
                "lombok.extern.slf4j.Slf4j",
                "org.springframework.cloud.stream.annotation.EnableBinding",
                "org.springframework.cloud.stream.annotation.StreamListener",
                "org.springframework.stereotype.Component",
                MessageConstant.MESSAGE_CLINET_PACKAGE +"." + String.format("%sMessageClient", StringUtil.firstUpper(this.getName()))
        });
    }

    @Override
    protected String getPackageName() {
        return MessageConstant.MESSAGE_SERVICE_PACKAGE;
    }

    @Override
    public String getClassName(String name) {
        return StringUtil.firstUpper(this.getName()) + "Service";
    }
}
