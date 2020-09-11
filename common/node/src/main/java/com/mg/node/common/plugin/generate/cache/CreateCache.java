package com.mg.node.common.plugin.generate.cache;

import com.mg.common.plugin.igenerate.ICreate;
import com.mg.common.unit.ClassUnit;
import com.mg.common.unit.MethodUnit;
import com.mg.common.util.StringUtil;
import com.mg.node.common.constant.CacheConstant;

import java.io.IOException;

public class CreateCache extends ICreate {

    Class pojoCl ;
    Class dtoCl;

    public CreateCache(String actionName, Class pojoClass,Class inDtoClass) {
        super(actionName , null);
        String method[] = new String[]{
               "getPojo","updatePojo","deletePojo","getId"
        };
        this.getItem().setMethods(method);
        this.pojoCl = pojoClass;
        this.dtoCl = inDtoClass;
    }

    @Override
    protected void createPre(ClassUnit unit) throws IOException {

        unit.addPreContent("@Autowired");
        unit.addPreContent("CacheStore store;");
        unit.addPreContent(String.format("public %s(){new CacheStore().add(%s.class,this);}",getClassName(unit.getName()),this.pojoCl.getSimpleName()));

    }

    @Override
    protected void createPreEachMethod(MethodUnit munit) throws IOException {

    }

    @Override
    protected void createMethod(MethodUnit unit) throws IOException {

        unit.addAnnotation("Override");
        if(unit.getName().equals("getId"))
        {
            unit.setReturnValue("Long");
            unit.setDecorate("public");
            unit.addParam(this.pojoCl.getSimpleName(),"pojo");
            unit.addTabContent("return pojo.getId();");
            return;
        }


        unit.setReturnValue(this.pojoCl.getSimpleName());
        unit.addParam("Long","id");
        if(unit.getName().equals("updatePojo"))
        {
            unit.addParam(pojoCl.getSimpleName(),"pojo");
        }

        unit.setDecorate("protected");
        unit.addTabContent("return null;");

    }

    @Override
    protected void classInit(ClassUnit unit) {
        unit.setBaseName(String.format("IBaseCache<%s,Long>",this.pojoCl.getSimpleName()));
        unit.addAnnotion("Service");
        unit.addAnnotion("Slf4j");


        unit.addImport("lombok.extern.slf4j.Slf4j");
        unit.addImport("org.springframework.stereotype.Service");
        unit.addImport("java.util.List");
        unit.addImport(this.pojoCl.getName());
        unit.addImport(this.dtoCl.getName());
        unit.addImport("com.mg.node.common.service.cache.IBaseCache");
        unit.addImport("org.springframework.beans.factory.annotation.Autowired");

    }

    @Override
    protected String getPackageName() {
        return CacheConstant.CACHE_PACKAGE;
    }

    @Override
    public String getClassName(String name) {
        return StringUtil.firstUpper(this.getName()) + "Cache";
    }


}
