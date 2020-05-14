package com.mg.website.uauth.common.generate.action;

import com.mg.common.constant.ConverCommonConstant;
import com.mg.common.iservice.ibasic.ICreate;
import com.mg.common.unit.ClassUnit;
import com.mg.common.unit.MethodUnit;
import com.mg.common.util.StringUtil;
import com.mg.website.uauth.common.constant.ActionConstant;
import com.mg.website.uauth.common.constant.CommonConstant;

import java.io.IOException;
import java.lang.reflect.Field;

public class CreateAction extends ICreate {


    Class toolClass;
    Class pojoClass;


    public CreateAction(String actionName, Class toolClass, Class pojoClass, String[] methods) {
        super(actionName, methods);
        this.toolClass = toolClass;
        this.pojoClass = pojoClass;
        this.setOverwrite(false);
    }
    String dtoName = StringUtil.firstUpper(this.getName()) +"DTO";
    String constantClassName = StringUtil.firstUpper(this.getName()) +"ControllerConstant";


    @Override
    protected void createPre(ClassUnit unit) throws IOException {
        unit.addPreContent("@Autowired");
        unit.addPreContent(String.format("%s dto;",dtoName));
        unit.addPreContent("\r\n");
        unit.addPreContent("@Autowired");
        unit.addPreContent(String.format("%s commonUtil;",this.toolClass.getSimpleName()));
    }

    @Override
    protected void createPreEachMethod(MethodUnit munit) throws IOException {

    }

    @Override
    protected void createMethod(MethodUnit unit) throws IOException {
        unit.addAnnotation(String.format("RequestMapping(%s.ACTION_%s)",this.constantClassName,unit.getName().toUpperCase()));
        unit.setReturnValue("ApiResultItem");
        unit.setDecorate("public");
        unit.addParam("@RequestBody JSONObject" ,"params");
        unit.addException("Exception");

        if(unit.getName().indexOf("get")>=0)
        {
            unit.addTabContent(String.format("%s pojo = new %s();",this.pojoClass.getSimpleName(),this.pojoClass.getSimpleName()));
            unit.addTabContent(String.format("pojo.setId(params.getString(\"id\"));"));
            unit.addTabContent(String.format("return dto.%s(commonUtil.toCommon(pojo));",unit.getName()));
        }
        else if(unit.getName().indexOf("edit")>=0)
        {
            unit.addTabContent(String.format("%s pojo = new %s();",this.pojoClass.getSimpleName(),this.pojoClass.getSimpleName()));
            Field[] fields = this.pojoClass.getDeclaredFields();
            StringUtil stringUtil = new StringUtil();
            for(Field field: fields)
            {
                unit.addTabContent(String.format("pojo.set%s(params.get%s(\"%s\"));",stringUtil.firstUpper(field.getName()),field.getType().getSimpleName(),field.getName()));
            }

            unit.addTabContent(String.format("return dto.%s(commonUtil.toCommon(pojo));",unit.getName()));
        }
        else if(unit.getName().indexOf("list")>=0)
        {
            unit.addTabRightContent(String.format("return dto.list(commonUtil.success());"));
        }
        else if(unit.getName().indexOf("delete")>=0)
        {
            unit.addTabRightContent(String.format("%s pojo = new %s();",this.pojoClass.getSimpleName(),this.pojoClass.getSimpleName()));
            unit.addTabContent(String.format("pojo.setId(params.getString(\"id\"));"));
            unit.addTabContent(String.format("return dto.delete(commonUtil.toCommon(pojo));"));
        }
        else {
            unit.addTabRightContent(String.format("return dto.%s(item);", unit.getName()));
        }
    }

    @Override
    protected void classInit(ClassUnit unit) {
        unit.addImport(new String[]{
                this.toolClass.getName(),
                "lombok.extern.slf4j.Slf4j",
                "org.springframework.web.bind.annotation.RestController",
                "org.springframework.web.bind.annotation.RequestMapping",
                ConverCommonConstant.CONVERT_COMMON_POJO+".CommonItem",
                "org.springframework.beans.factory.annotation.Autowired",
                ActionConstant.ACTION_DTO_PACKAGE +"."+dtoName,
                ActionConstant.ACTION_CONSTANT_PACKAGE+"." + constantClassName,
                "org.springframework.web.bind.annotation.RequestBody",
                "com.alibaba.fastjson.JSONObject",
                CommonConstant.POJO_COMMON +".ApiResultItem",
                this.pojoClass.getName()});

    }

    @Override
    protected String getPackageName() {
        return ActionConstant.ACTION_PACKAGE;
    }

    @Override
    public String getClassName(String name) {
        return StringUtil.firstUpper(this.getName()) + "Controller";
    }
}
