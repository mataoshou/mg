package com.mg.node.common.generate.action;

import com.mg.common.constant.BasicCommonConstant;
import com.mg.common.iservice.ibasic.ICreate;
import com.mg.common.unit.ClassUnit;
import com.mg.common.unit.MethodUnit;
import com.mg.common.util.StringUtil;
import com.mg.node.common.constant.ActionConstant;
import com.mg.node.common.constant.CommonConstant;

import java.io.IOException;

public class CreateAction extends ICreate {


    Class inDto;
    Class outDto;

    Class inVo;
    Class outVo;


    public CreateAction(String actionName,  Class inVo, Class outVo,
                        Class inDto, Class outDto, String[] methods) {
        super(actionName, methods);
        this.inDto = inDto;
        this.outDto = outDto;
        this.inVo = inVo;
        this.outVo = outVo;
        this.setOverwrite(false);
    }
    String repositoryName = StringUtil.firstUpper(this.getName()) +"Repository";
    String constantClassName = StringUtil.firstUpper(this.getName()) +"ControllerConstant";


    @Override
    protected void createPre(ClassUnit unit) throws IOException {
        unit.addPreContent("@Autowired");
        unit.addPreContent(String.format("%s repository;",repositoryName));

        unit.addPreContent("@Autowired");
        unit.addPreContent(String.format("GeneralMapper mapper;",repositoryName));
    }

    @Override
    protected void createPreEachMethod(MethodUnit munit) throws IOException {

    }

    @Override
    protected void createMethod(MethodUnit unit) throws IOException {
        unit.addAnnotation(String.format("RequestMapping(%s.ACTION_%s)",this.constantClassName,unit.getName().toUpperCase()));
        unit.setReturnValue("ResultItem");
        unit.setDecorate("public");
        unit.addParam(String.format("@RequestBody %s",this.inVo.getSimpleName()) ,"voData");
        unit.addException("Exception");

        unit.addTabContent(String.format("%s pojo = mapper.convert(voData,%s.class);",
                this.inDto.getSimpleName(),this.inDto.getSimpleName()));
        unit.addTabContent(String.format("return repository.%s(pojo);", unit.getName()));
//        if(unit.getName().indexOf("get")>=0)
//        {
//            unit.addTabContent(String.format("return repository.%s(pojo);",unit.getName()));
//        }
//        else if(unit.getName().indexOf("edit")>=0)
//        {
//            unit.addTabContent(String.format("return repository.%s(pojo);",unit.getName()));
//        }
//        else if(unit.getName().indexOf("list")>=0)
//        {
//            unit.addTabContent(String.format("return repository.%s(pojo);",unit.getName()));
//        }
//        else if(unit.getName().indexOf("delete")>=0)
//        {
//            unit.addTabContent(String.format("return repository.%s(pojo);",unit.getName()));
//        }
//        else {
//            unit.addTabRightContent(String.format("return repository.%s(item);", unit.getName()));
//        }
    }

    @Override
    protected void classInit(ClassUnit unit) {
        unit.addImport(new String[]{
                this.inVo.getName(),
                this.inDto.getName(),
                this.outDto.getName(),
                this.outVo.getName(),
                "lombok.extern.slf4j.Slf4j",
                "org.springframework.web.bind.annotation.RestController",
                "org.springframework.web.bind.annotation.RequestMapping",
                "org.springframework.beans.factory.annotation.Autowired",
                ActionConstant.ACTION_REPOSITORY_PACKAGE +"."+repositoryName,
                ActionConstant.ACTION_CONSTANT_PACKAGE+"." + constantClassName,
                "org.springframework.web.bind.annotation.RequestBody",
//                "com.alibaba.fastjson.JSONObject",
                BasicCommonConstant.POJO_COMMON +".ResultItem",
                CommonConstant.MAPPER_PACKAGE +".GeneralMapper"});

        unit.addAnnotion("Slf4j");
        unit.addAnnotion("RestController");

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
