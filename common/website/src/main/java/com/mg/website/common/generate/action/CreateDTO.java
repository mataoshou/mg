package com.mg.website.common.generate.action;

import com.mg.common.constant.ConverCommonConstant;
import com.mg.common.iservice.ibasic.ICreate;
import com.mg.common.unit.ClassUnit;
import com.mg.common.unit.MethodUnit;
import com.mg.common.util.StringUtil;
import com.mg.website.common.constant.ActionConstant;
import com.mg.website.common.constant.CommonConstant;
import com.mg.website.common.constant.ConvertsConstant;
import com.mg.website.common.constant.FeignConstant;

import java.io.IOException;

public class CreateDTO extends ICreate {

    Class resultClass;
    Class paramClass;
    public CreateDTO(String name, Class paramClass,Class resultClass, String[] methods) {
        super(name, methods);
        this.paramClass = paramClass;
        this.resultClass = resultClass;
    }

    @Override
    protected void createPre(ClassUnit unit) throws IOException {

        unit.addPreContent("@Autowired");
        unit.addPreContent(String.format("%sFeign feign;",StringUtil.firstUpper(this.getName())));

    }

    @Override
    protected void createPreEachMethod(MethodUnit munit) throws IOException {

    }


    @Override
    protected void createMethod(MethodUnit unit) throws IOException {

        unit.setDecorate("public");
        unit.setReturnValue("ApiResultItem");
        unit.addParam(paramClass.getSimpleName(),"item");
        unit.addException("Exception");

        if(unit.getName().indexOf("list")>=0) {
            unit.addTabContent(String.format("List<%s> result =  feign.%s(item);",resultClass.getSimpleName(),unit.getName()));
            unit.addTabContent(String.format("return new ApiResultItem(result);"));
        }
        else {
            unit.addTabContent(String.format("%s result =  feign.%s(item);",resultClass.getSimpleName(),unit.getName()));
            unit.addTabContent(String.format("return new ApiResultItem(result);"));
        }
    }

    @Override
    protected void classInit(ClassUnit unit) {
        unit.addImport(new String[]{"org.springframework.stereotype.Service",
                this.paramClass.getName(),
                "lombok.extern.slf4j.Slf4j",this.resultClass.getName(),
                "org.springframework.beans.factory.annotation.Autowired",
//                FeignConstant.FEIGN_PACKAGE +"."+baseName + "Feign",
                CommonConstant.POJO_COMMON +".ApiResultItem",
                FeignConstant.FEIGN_PACKAGE+String.format(".%sFeign",StringUtil.firstUpper(this.getName()))});
        unit.addImport("java.util.List");
        unit.addAnnotion("Service");
        unit.addAnnotion("Slf4j");
    }

    @Override
    protected String getPackageName() {
        return  ActionConstant.ACTION_REPOSITORY_PACKAGE;
    }

    @Override
    public String getClassName(String name) {
        return StringUtil.firstUpper(this.getName()) + "Repository";
    }
}
