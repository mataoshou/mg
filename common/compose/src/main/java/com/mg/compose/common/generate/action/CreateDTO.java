package com.mg.compose.common.generate.action;

import com.mg.common.iservice.ibasic.ICreate;
import com.mg.common.unit.ClassUnit;
import com.mg.common.unit.MethodUnit;
import com.mg.compose.common.constant.ActionConstant;
import com.mg.compose.common.constant.ConvertsConstant;
import com.mg.compose.common.constant.FeignConstant;

import java.io.IOException;

public class CreateDTO extends ICreate {

    Class toolClass;
    Class pojoClass;
    public CreateDTO(String name, Class toolClass, Class pojoClass, String[] methods) {
        super(name, methods);
        this.toolClass = toolClass;
        this.pojoClass = pojoClass;
        init();
    }

    @Override
    protected void createPre(ClassUnit unit) throws IOException {

    }

    @Override
    protected void createPreEachMethod(MethodUnit munit) throws IOException {

    }


    @Override
    protected void createMethod(MethodUnit unit) throws IOException {

    }

    @Override
    protected void classInit(ClassUnit unit) {
        unit.addImport(new String[]{"org.springframework.stereotype.Service",
                this.toolClass.getName(),
                "lombok.extern.slf4j.Slf4j",this.pojoClass.getName(),
                "org.springframework.beans.factory.annotation.Autowired",
//                FeignConstant.FEIGN_PACKAGE +"."+baseName + "Feign",
                ConvertsConstant.POJO_PACKAGE+".QueryItem",
                ConvertsConstant.UTIL_PACKAGE+".QueryItemCommonUtil",
                ConvertsConstant.CONVERT_COMMON_PACKAGE+".CommonItem",
                ActionConstant.ACTION_COMMON_DB +".ApiResultItem",
                FeignConstant.FEIGN_PACKAGE+String.format(".%sFeign",this.getName())});

        unit.addAnnotion("Service");
        unit.addAnnotion("Slf4j");
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
