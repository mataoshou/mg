package com.mg.website.common.plugin.generate.feign;

import com.mg.common.constant.BasicCommonConstant;
import com.mg.common.plugin.igenerate.ICreate;
import com.mg.common.unit.ClassUnit;
import com.mg.common.unit.MethodUnit;
import com.mg.common.util.StringUtil;
import com.mg.website.common.constant.FeignConstant;

import java.io.IOException;

public class CreateFeign extends ICreate {


    Class incl;
    Class outcl;

    public CreateFeign(String name, String[] methods,Class inCl,Class outCl) {
        super(name, methods);
        this.incl =inCl;
        this.outcl = outCl;
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
        unit.addParam(incl.getSimpleName(),"item");
        unit.addAnnotation(String.format("RequestMapping(%s.FEIGN_%s)",constantClassName,unit.getName().toUpperCase()));
        unit.setReturnValue(String.format("ResultItem<%s>",outcl.getSimpleName()));
    }

    @Override
    protected void classInit(ClassUnit unit) {
        String fallbackName = StringUtil.firstUpper(this.getName()) +"FeignFallBackFactory";

        unit.addImport(new String[]{
                "lombok.extern.slf4j.Slf4j",
                "org.springframework.cloud.openfeign.FeignClient",
                "org.springframework.web.bind.annotation.RequestMapping",
                BasicCommonConstant.POJO_COMMON +".ResultItem",
                FeignConstant.FEIGN_CONSTANT_PACKAGE + "." +constantClassName,
                this.incl.getName(),
                this.outcl.getName()
        });

        unit.setType(2);
        unit.addAnnotion(String.format("FeignClient(name = %s.FEIGN_SERVER_NAME,fallbackFactory = %s.class)",constantClassName,fallbackName));
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
