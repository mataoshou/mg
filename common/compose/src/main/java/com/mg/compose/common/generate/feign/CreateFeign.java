package com.mg.compose.common.generate.feign;

import com.mg.common.constant.ConverCommonConstant;
import com.mg.common.iservice.ibasic.ICreate;
import com.mg.common.unit.ClassUnit;
import com.mg.common.unit.MethodUnit;
import com.mg.common.util.StringUtil;
import com.mg.compose.common.constant.FeignConstant;

import java.io.IOException;

public class CreateFeign extends ICreate {


    public CreateFeign(String name, String[] methods,String sysName) {
        super(name, methods);
    }

    @Override
    protected void createPre(ClassUnit unit) throws IOException {

    }

    @Override
    protected void createPreEachMethod(MethodUnit munit) throws IOException {

    }

    String constantClassName = StringUtil.firstUpper(this.getName()) +"FeignConstant";
    @Override
    protected void createMethod(MethodUnit unit) throws IOException {
        unit.setType(unit.METHOD_TYPE_ABSTRACT);
        unit.addAnnotation(String.format("RequestMapping(%s.FEIGN_%s)",constantClassName,unit.getName().toUpperCase()));
        unit.setReturnValue("CommonItem");
    }

    @Override
    protected void classInit(ClassUnit unit) {
        String fallbackName = StringUtil.firstUpper(this.getName()) +"FeignFallBack";

        unit.addImport(new String[]{
                "lombok.extern.slf4j.Slf4j",
                ConverCommonConstant.CONVERT_COMMON_POJO+".CommonItem",
                "org.springframework.cloud.openfeign.FeignClient",
                "org.springframework.web.bind.annotation.RequestMapping",
                FeignConstant.FEIGN_CONSTANT_PACKAGE + "." +constantClassName
        });

        unit.setType(2);
        unit.addAnnotion(String.format("FeignClient(name = %s.FEIGN_SERVER_NAME,fallback = %s.class)",constantClassName,fallbackName));
    }

    @Override
    protected String getPackageName() {
        return FeignConstant.FEIGN_PACKAGE;
    }

    @Override
    public String getClassName(String name) {
        return StringUtil.firstUpper(name) +"Feign";
    }
}
