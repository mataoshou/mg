package com.mg.website.uauth.common.generate.action;

import com.mg.common.constant.ConverCommonConstant;
import com.mg.common.iservice.ibasic.ICreate;
import com.mg.common.unit.ClassUnit;
import com.mg.common.unit.MethodUnit;
import com.mg.common.util.StringUtil;
import com.mg.website.uauth.common.constant.ActionConstant;
import com.mg.website.uauth.common.constant.CommonConstant;
import com.mg.website.uauth.common.constant.ConvertsConstant;
import com.mg.website.uauth.common.constant.FeignConstant;

import java.io.IOException;

public class CreateDTO extends ICreate {

    Class toolClass;
    Class pojoClass;
    public CreateDTO(String name, Class toolClass, Class pojoClass, String[] methods) {
        super(name, methods);
        this.toolClass = toolClass;
        this.pojoClass = pojoClass;
    }

    @Override
    protected void createPre(ClassUnit unit) throws IOException {
        unit.addPreContent("@Autowired");
        unit.addPreContent(String.format("QueryItemCommonUtil queryItemCommonUtil;"));

        unit.addPreContent("@Autowired");
        unit.addPreContent(String.format("%sFeign feign;",StringUtil.firstUpper(this.getName())));


        unit.addPreContent("@Autowired");
        unit.addPreContent(String.format("%s commonUtil;",this.toolClass.getSimpleName()));
    }

    @Override
    protected void createPreEachMethod(MethodUnit munit) throws IOException {

    }


    @Override
    protected void createMethod(MethodUnit unit) throws IOException {

        unit.setDecorate("public");
        unit.setReturnValue("ApiResultItem");
        unit.addParam("CommonItem","item");
        unit.addException("Exception");

        unit.addTabContent(String.format("CommonItem result =  feign.%s(item);",unit.getName()));
        if(unit.getName().indexOf("list")>=0) {
            unit.addTabContent(String.format("return  new ApiResultItem(result ,commonUtil.toPojoList(result));"));
        }
        else {
            unit.addTabContent(String.format("return new ApiResultItem(result ,commonUtil.toPojo(result));"));
        }
    }

    @Override
    protected void classInit(ClassUnit unit) {
        unit.addImport(new String[]{"org.springframework.stereotype.Service",
                this.toolClass.getName(),
                "lombok.extern.slf4j.Slf4j",this.pojoClass.getName(),
                "org.springframework.beans.factory.annotation.Autowired",
//                FeignConstant.FEIGN_PACKAGE +"."+baseName + "Feign",
                ConvertsConstant.UTIL_PACKAGE+".QueryItemCommonUtil",
                ConverCommonConstant.CONVERT_COMMON_POJO+".CommonItem",
                CommonConstant.POJO_COMMON +".ApiResultItem",
                FeignConstant.FEIGN_PACKAGE+String.format(".%sFeign",StringUtil.firstUpper(this.getName()))});

        unit.addAnnotion("Service");
        unit.addAnnotion("Slf4j");
    }

    @Override
    protected String getPackageName() {
        return  ActionConstant.ACTION_DTO_PACKAGE;
    }

    @Override
    public String getClassName(String name) {
        return StringUtil.firstUpper(this.getName()) + "DTO";
    }
}
