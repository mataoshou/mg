package com.mg.node.common.generate.dao;

import com.mg.common.iservice.ibasic.ICreate;
import com.mg.common.unit.ClassUnit;
import com.mg.common.unit.MethodUnit;
import com.mg.common.util.GuidUtil;
import com.mg.common.util.StringUtil;
import com.mg.node.common.constant.DBConstant;
import com.mg.node.common.constant.DAOConstant;
import jdk.nashorn.internal.ir.UnaryNode;

import java.io.IOException;

public class CreateDAO extends ICreate {


    Class poCl;

    public CreateDAO(String name, String[] methods,Class poCl) {
        super(name, methods);
        this.poCl = poCl;
    }



    @Override
    protected void createPre(ClassUnit unit) throws IOException {
        unit.addPreContent("@Autowired");
        unit.addPreContent(String.format("private IGeneralMapper<%s> mapper;",this.poCl.getSimpleName()));
        unit.addPreContent("\r");
//
//        unit.addPreContent("@Autowired");
//        unit.addPreContent(String.format("private GuidUtil guidUtil;"));

    }

    @Override
    protected void createPreEachMethod(MethodUnit munit) throws IOException {

    }

    @Override
    protected void createMethod(MethodUnit unit) throws IOException {
        unit.setDecorate("public");
        if(unit.getName().indexOf("get")>=0) {
            unit.setReturnValue(this.poCl.getSimpleName());
            unit.addParam("Long" ,"id");

            unit.addTabContent("return mapper.getById(id);");

        }
        else if(unit.getName().indexOf("delete")>=0)
        {
            unit.setReturnValue("boolean");
            unit.addParam("Long" ,"id");

            unit.addTabContent("int count = mapper.deleteById(id);");
            unit.addTabContent("if(count>0) { return true; }");
            unit.addTabContent("return false;");
        }
        else if(unit.getName().indexOf("list")>=0)
        {
            unit.setReturnValue(String.format("List<%s>",this.poCl.getSimpleName()));
            unit.addTabContent("return mapper.listByWhere(null,null);");
        }
//        else if(unit.getName().indexOf("insert")>=0){
//            unit.setReturnValue(this.poCl.getSimpleName());
//
//            unit.addParam(this.poCl.getSimpleName() ,"item");
//            unit.addTabContent("GuidUtil guidUtil = new GuidUtil();");
//            unit.addTabContent("String id = guidUtil.gen();");
//            unit.addTabContent("item.setId(id);");
//            unit.addTabContent("mapper.insertByCustomId(item);");
//            unit.addTabContent("return get(id);");
//        }
//        else if(unit.getName().indexOf("update")>=0)
//        {
//            unit.setReturnValue(this.poCl.getSimpleName());
//            unit.addParam(this.poCl.getSimpleName() ,"item");
//
//            unit.addTabContent("mapper.updateByPrimaryKey(item);");
//            unit.addTabContent("return get(item.getId());");
//        }
        else{
            unit.setReturnValue(this.poCl.getSimpleName());
            unit.addParam(this.poCl.getSimpleName() ,"item");
            unit.addTabContent("return null;");
        }
    }

    @Override
    protected void classInit(ClassUnit unit) {
        unit.addAnnotion("Repository");

        unit.addImport(new String[]{
                "org.springframework.beans.factory.annotation.Autowired",
                "org.springframework.stereotype.Repository",
//                DBConstant.DB_MERGEDAO_PACKAGE+"."+getMapperName(),
                this.poCl.getName(),
                "java.util.List",
                "com.mg.common.util.GuidUtil",
                "com.mg.node.common.frame.mgmybatis.imp.IGeneralMapper"
//                UtilConstant.UTIL_PACKAGE +".GuidUtil"
        });
    }

    @Override
    protected String getPackageName() {
        return DAOConstant.DAO_PACKAGE;
    }

    @Override
    public String getClassName(String name) {
        return StringUtil.firstUpper(name) + "DAO";
    }
}
