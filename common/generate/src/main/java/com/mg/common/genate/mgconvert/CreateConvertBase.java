package com.mg.common.genate.mgconvert;

import com.mg.common.genate.ibasic.ICreate;
import com.mg.common.unit.ClassUnit;
import com.mg.common.unit.MethodUnit;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;

public class CreateConvertBase extends ICreate {


    public CreateConvertBase(String name, String[] methods) {
        super(name, methods);
    }

    @Override
    protected void createPreMethod(ClassUnit unit) throws IOException {

        ArrayBlockingQueue

        classBuildUtil.classInit(this.getClassName(),null,
                new String[]{String.format("CommonItemUtils<%s>",this.getItem().getPojoClassName())}, this.getPackageName(),null,true,
                "java.util.Date", String.format("%s.%s", ConvertsConstant.POJO_PACKAGE,this.getItem().getPojoClassName()), ConvertsConstant.CONVERT_COMMON_PACKAGE+".CommonData",
                "java.util.ArrayList","java.util.List","org.springframework.beans.factory.annotation.Autowired",
                ConvertsConstant.CONVERT_COMMON_PACKAGE+".CommonItemUtils",
                ConvertsConstant.CONVERT_COMMON_PACKAGE+".CommonItem",
                ConvertsConstant.CONVERT_COMMON_PACKAGE+".CommonItemUtils",
                "org.slf4j.Logger","org.slf4j.LoggerFactory");
    }

    @Override
    protected void createMethod(MethodUnit unit) throws IOException {

    }

    @Override
    protected void classInit(ClassUnit unit) {
        unit.addImport("java.util.Date")
                .addImport("java.util.ArrayList")
                .addImport("java.util.List")
                .addImport("org.springframework.beans.factory.annotation.Autowired")
                .addImport("java.util.List");
    }

    @Override
    protected String getPackageName() {
        return null;
    }

    @Override
    public String getClassName(String name) {
        return null;
    }
}
