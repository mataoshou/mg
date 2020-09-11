package com.mg.node.common.plugin.generate.action;

import com.mg.common.constant.BasicCommonConstant;
import com.mg.common.plugin.igenerate.ICreate;
import com.mg.common.unit.ClassUnit;
import com.mg.common.unit.MethodUnit;
import com.mg.common.util.StringUtil;
import com.mg.node.common.constant.ActionConstant;
import com.mg.node.common.constant.CommonConstant;
import com.mg.node.common.constant.DAOConstant;
import com.mg.node.common.constant.FeignConstant;

import java.io.IOException;

public class CreateRepository extends ICreate {

    Class inDto;
    Class outDto;
    Class po;

    public CreateRepository(String name,  Class inDto, Class outDto, Class po, String[] methods) {
        super(name, methods);
        this.inDto = inDto;
        this.outDto = outDto;
        this.po =po;
    }

    @Override
    protected void createPre(ClassUnit unit) throws IOException {

        unit.addPreContent("@Autowired");
        unit.addPreContent(String.format("%sDAO dao;",StringUtil.firstUpper(this.getName())));
        unit.addPreContent("@Autowired");
        unit.addPreContent(String.format("GeneralMapper mapper;"));
    }

    @Override
    protected void createPreEachMethod(MethodUnit munit) throws IOException {

    }


    @Override
    protected void createMethod(MethodUnit unit) throws IOException {

        unit.setDecorate("public");
        unit.setReturnValue("ResultItem");
        unit.addParam(inDto.getSimpleName(),"item");
        unit.addException("Exception");
//        unit.addTabContent(String.format("ResultItem result =  dao.%s(item);",unit.getName()));
//        unit.addTabContent(String.format("return result;"));

        if(unit.getName().indexOf("get")>=0) {

            unit.addTabContent(String.format("%s pojo = dao.get(item.getId());",po.getSimpleName()));
            unit.addTabContent(String.format("%s dto = mapper.convert(pojo,%s.class);",outDto.getSimpleName(),outDto.getSimpleName()));
            unit.addTabContent(String.format("ResultItem result =  new ResultItem<%s>(dto);",outDto.getSimpleName()));
            unit.addTabContent(String.format("return result;"));

        }
        else if(unit.getName().indexOf("delete")>=0)
        {
            unit.addTabContent(String.format("dao.delete(item.getId());"));
            unit.addTabContent(String.format("ResultItem result = new ResultItem();"));
            unit.addTabContent(String.format("return result;"));
        }
        else if(unit.getName().indexOf("list")>=0)
        {
            unit.addTabContent(String.format("List<%s> list = dao.list();",po.getSimpleName()));
            unit.addTabContent(String.format("ResultItem result =  new ResultItem<%s>(mapper.convert(list,%s.class));"
                    ,outDto.getSimpleName(),outDto.getSimpleName()));
            unit.addTabContent(String.format("return result;"));

        }
        else if(unit.getName().indexOf("edit")>=0){

            unit.addTabContent(String.format("%s pojo = mapper.convert(item,%s.class);",po.getSimpleName(),po.getSimpleName()));
            unit.addTabContent(String.format("ResultItem result = new ResultItem<%s>(mapper.convert(dao.edit(pojo),%s.class));"
                    ,outDto.getSimpleName(),outDto.getSimpleName()));
            unit.addTabContent(String.format("return result;"));

        }
        else{
            unit.addTabContent("return null;");
        }
    }

    @Override
    protected void classInit(ClassUnit unit) {
        unit.addImport(new String[]{"org.springframework.stereotype.Service",
                this.outDto.getName(),
                this.inDto.getName(),
                "lombok.extern.slf4j.Slf4j",this.po.getName(),
                "org.springframework.beans.factory.annotation.Autowired",
//                FeignConstant.FEIGN_PACKAGE +"."+baseName + "Feign",
                BasicCommonConstant.POJO_COMMON +".ResultItem",
                CommonConstant.FEIGN_COMMON_MAPPER +".GeneralMapper",
                DAOConstant.DAO_PACKAGE +String.format(".%sDAO",StringUtil.firstUpper(this.getName())),
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
