package com.mg.compose.common.generate.convert;

import com.mg.common.constant.ConverCommonConstant;
import com.mg.common.iservice.ibasic.ICreate;
import com.mg.common.unit.ClassUnit;
import com.mg.common.unit.MethodUnit;
import com.mg.common.util.ClassUtil;
import com.mg.common.util.StringUtil;
import com.mg.common.pojo.SimpleItem;
import com.mg.compose.common.constant.ConvertsConstant;

import java.io.IOException;
import java.lang.reflect.Field;

public class CreateConvertBase extends ICreate {


    Class  pojoClass;
    String sysName;
    Field[] items;

    public CreateConvertBase(String actionName, Class pojoClass) {
        super(actionName,new String[]{
                "toCommonData","toPojoData" ,"toCommon" ,"toCommonList" ,"toPojo" ,"toPojoList"
        });


        this.pojoClass = pojoClass;
        this.sysName = sysName;
        items = ConvertTools.getFields(this.pojoClass);

    }





    private void toCommonData(MethodUnit unit)
    {

        unit.setReturnValue("CommonData");
        unit.setDecorate("private");
        unit.addParam(this.pojoClass.getSimpleName(),"pojo");

        unit.addTabContent(String.format("CommonData data = new CommonData();" ));

        for(Field item:items)
        {
            String getMehod = ClassUtil.getGetMethodName(item.getName());

            String str = String.format("data.addParam(\"%s\",pojo.%s());",item.getName(), getMehod);

            unit.addTabContent(str);
        }
        unit.addTabContent("return data;");
    }


    private void toPojoData(MethodUnit unit)
    {

        unit.setReturnValue(this.pojoClass.getSimpleName());
        unit.setDecorate("private");
        unit.addParam("CommonData","data");

        unit.addTabContent(String.format("%s pojo = new %s();",this.pojoClass.getSimpleName(),this.pojoClass.getSimpleName() ));

        for(Field item:items)
        {
                String setMethod = ClassUtil.getSetMethodName(item.getName());
                String str = String.format("pojo.%s(data.%s(\"%s\"));", setMethod, ConvertTools.getMethod(item),item.getName());


                unit.addTabContent( str);
        }
        unit.addTabContent("return pojo;");
    }

    private void toCommon(MethodUnit unit)
    {
        unit.addAnnotation("Override");
        unit.setReturnValue("CommonItem");
        unit.setDecorate("public");
        unit.addParam(this.pojoClass.getSimpleName(),"pojo");

        unit.addTabRightContent("return success(toCommonData(pojo));");

    }

    private void toCommonList(MethodUnit unit)
    {

        unit.setName("toCommon");
        unit.addAnnotation("Override");
        unit.setReturnValue("CommonItem");
        unit.setDecorate("public");
        unit.addParam(String.format("List<%s>",this.pojoClass.getSimpleName()),"pojos");


        unit.addTabContent(String.format("List<CommonData> result = new ArrayList();" ));
        unit.addTabContent(String.format("for(%s item : pojos){",this.pojoClass.getSimpleName()));
        unit.addTabRightContent(String.format("result.add(toCommonData(item));"));
        unit.addTabLeftContent(String.format("}"));
        unit.addTabContent("return success(result);");

    }


    private void toPojo(MethodUnit unit)
    {
        unit.addAnnotation("Override");
        unit.setReturnValue(this.pojoClass.getSimpleName());
        unit.setDecorate("public");
        unit.addParam("CommonItem","item");
        unit.addException("Exception");

        unit.addTabContent(String.format("checkCommonItem(item);"));

        unit.addTabContent(String.format("List<CommonData> datas = item.getDatas();"));

        unit.addTabContent(String.format("if(datas ==null||datas.size()==0){log.debug(\"CommonItem 中data数据为空!!\"); return null;}"));

        unit.addTabContent(String.format("if(datas.size()>1){log.debug(\"CommonItem 中data数据不止一条数据!!\"); }"));

        unit.addTabContent("return toPojoData(datas.get(0));");
    }



    private void toPojoList(MethodUnit unit)
    {
        unit.addAnnotation("Override");
        unit.setReturnValue(String.format("List<%s>",this.pojoClass.getSimpleName()));
        unit.setDecorate("public");
        unit.addParam("CommonItem","item");
        unit.addException("Exception");

        unit.addTabContent(String.format("checkCommonItem(item);"));

        unit.addTabContent(String.format("List<%s> result = new ArrayList();",this.pojoClass.getSimpleName() ));
        unit.addTabContent(String.format("List<CommonData> datas = item.getDatas();" ));

        unit.addTabContent(String.format("for(CommonData data : datas){"));
        unit.addTabRightContent(String.format("result.add(toPojoData(data));"));
        unit.addTabLeftContent(String.format("}"));

        unit.addTabContent("return result;");
    }


    @Override
    protected void createPre(ClassUnit unit) throws IOException {

    }

    @Override
    protected void createPreEachMethod(MethodUnit munit) throws IOException {

    }

    @Override
    protected void createMethod(MethodUnit unit) throws IOException {


        switch (unit.getName())
        {
            case "toCommonData":toCommonData(unit);break;
            case "toPojoData":toPojoData(unit);break;
            case "toCommon":toCommon(unit);break;
            case "toCommonList":toCommonList(unit);break;
            case "toPojo":toPojo(unit);break;
            case "toPojoList":toPojoList(unit);break;
        }
    }

    @Override
    protected void classInit(ClassUnit unit) {

        setOverwrite(true);
        unit.setPackageName(getPackageName());
        unit.addImport(new String[]{
                this.pojoClass.getName(),
                ConverCommonConstant.CONVERT_COMMON_POJO+".CommonData",
                "java.util.ArrayList","java.util.List",
                ConvertsConstant.CONVERT_COMMON_PACKAGE+".CommonItemUtils",
                ConverCommonConstant.CONVERT_COMMON_POJO+".CommonItem",
                "lombok.extern.slf4j.Slf4j"});

        unit.addAnnotion("Slf4j");
        unit.addImplement(String.format("CommonItemUtils<%s>",this.pojoClass.getSimpleName()));

    }

    @Override
    protected String getPackageName() {
        return ConvertsConstant.BASE_PACKAGE;
    }

    @Override
    public String getClassName(String name) {
        return StringUtil.firstUpper(name) +"CommonBase";
    }


    public void testCreate() throws IOException {
        CreateConvertBase base = new CreateConvertBase("matao",
                SimpleItem.class);
        base.startCreate();
    }

}
