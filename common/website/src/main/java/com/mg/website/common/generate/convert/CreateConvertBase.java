package com.mg.website.common.generate.convert;

import com.mg.common.iservice.ibasic.ICreate;
import com.mg.common.unit.ClassUnit;
import com.mg.common.unit.MethodUnit;
import com.mg.common.util.StringUtil;
import com.mg.website.common.constant.ConvertsConstant;
import org.dom4j.DocumentException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CreateConvertBase extends ICreate {


    Class  toolClass;
    Class  pojoClass;
    String sysName;

    public CreateConvertBase(String actionName, Class toolClass, Class pojoClass, String sysName) {
        super(actionName,new String[]{
               "toCommonData","toPojoData" ,"toCommon" ,"toCommonList" ,"toPojo" ,"toPojoList"
        });
        this.toolClass = toolClass;
        this.pojoClass = pojoClass;
        this.sysName = sysName;
    }





    private void toCommonData(MethodUnit unit)
    {
        String methodName = "toCommonData";

        classBuildUtil.addTabContent(String.format("private CommonData %s( %s pojo) {" ,methodName,pojoName));

        classBuildUtil.addTabRightContent(String.format("CommonData data = new CommonData();" ));

        for(MapperItem item:items)
        {
            if(item.commonName.length()>0) {
                String getMehod = classBuildUtil.getGetMethodName(item.pojoName);
                String setMethod = classBuildUtil.getSetMethodName(item.commonName);

                String str = String.format("data.%s(pojo.%s());", setMethod, getMehod);
                classBuildUtil.addTabContent(str);
            }
        }
        classBuildUtil.addTabContent("return data;");

        classBuildUtil.addTabLeftContent(String.format("}"));

    }


    private void toPojoData(String pojoName, List<MapperItem> items , ClassBuildUtil classBuildUtil)
    {
        String methodName = "toPojoData";

        classBuildUtil.addTabContent(String.format("private %s %s( CommonData data) {" ,pojoName,methodName));

        classBuildUtil.addTabRightContent(String.format("%s pojo = new %s();",pojoName,pojoName ));

        for(MapperItem item:items)
        {
            if(item.commonName.length()>0) {
                String getMehod = classBuildUtil.getGetMethodName(item.commonName);
                String setMethod = classBuildUtil.getSetMethodName(item.pojoName);

                String str = String.format("pojo.%s(data.%s());", setMethod, getMehod);
                classBuildUtil.addTabContent( str);
            }
        }
        classBuildUtil.addTabContent("return pojo;");

        classBuildUtil.addTabLeftContent(String.format("}"));
    }

    private void toCommon(String pojoName , ClassBuildUtil classBuildUtil)
    {

        String methodName = "toCommon";

        classBuildUtil.addTabContent(String.format("public CommonItem %s( %s pojo) {" ,methodName,pojoName));

        classBuildUtil.addTabRightContent("return success(toCommonData(pojo));");


        classBuildUtil.addTabLeftContent(String.format("}"));

    }

    private void toCommonList(String pojoName , ClassBuildUtil classBuildUtil)
    {

        String methodName = "toCommon";

        classBuildUtil.addTabContent(String.format("public  CommonItem %s( List<%s> pojos) {" ,methodName,pojoName));

        classBuildUtil.addTabRightContent(String.format("List<CommonData> result = new ArrayList();" ));

        classBuildUtil.addTabContent(String.format("for(%s item : pojos){",pojoName));
        classBuildUtil.addTabRightContent(String.format("result.add(toCommonData(item));"));
        classBuildUtil.addTabLeftContent(String.format("}"));


        classBuildUtil.addTabContent("return success(result);");


        classBuildUtil.addTabLeftContent(String.format("}"));

    }


    private void toPojo(String pojoName , ClassBuildUtil classBuildUtil)
    {
        String methodName = "toPojo";

        classBuildUtil.addTabContent(String.format("public %s %s( CommonItem item) throws Exception{" ,pojoName,methodName));

        classBuildUtil.addTabRightContent(String.format("checkCommonItem(item);"));

        classBuildUtil.addTabContent(String.format("List<CommonData> datas = item.getDatas();"));

        classBuildUtil.addTabContent(String.format("if(datas ==null||datas.size()==0){logger.debug(\"CommonItem 中data数据为空!!\"); return null;}"));

        classBuildUtil.addTabContent(String.format("if(datas.size()>1){logger.debug(\"CommonItem 中data数据不止一条数据!!\"); }"));

        classBuildUtil.addTabContent("return toPojoData(datas.get(0));");


        classBuildUtil.addTabLeftContent(String.format("}"));
    }



    private void toPojoList(String pojoName, ClassBuildUtil classBuildUtil)
    {
        String methodName = "toPojoList";

        classBuildUtil.addTabContent(String.format("public List<%s> %s(  CommonItem item) throws Exception{" ,pojoName,methodName));

        classBuildUtil.addTabRightContent(String.format("checkCommonItem(item);"));

        classBuildUtil.addTabContent(String.format("List<%s> result = new ArrayList();",pojoName ));
        classBuildUtil.addTabRightContent(String.format("List<CommonData> datas = item.getDatas();" ));

        classBuildUtil.addTabContent(String.format("for(CommonData data : datas){"));
        classBuildUtil.addTabRightContent(String.format("result.add(toPojoData(data));"));
        classBuildUtil.addTabLeftContent(String.format("}"));

        classBuildUtil.addTabContent("return result;");


        classBuildUtil.addTabLeftContent(String.format("}"));
    }


    protected void classInit() {
        setConver(true);
    }

    @Override
    protected void createPreMethod(ClassUnit unit) throws IOException {

    }

    @Override
    protected void createMethod(MethodUnit unit) throws IOException {
        switch (unit.getName())
        {
            case "toCommonData":toCommonData(unit)
        }
    }

    @Override
    protected void classInit(ClassUnit unit) {

        unit.setPackageName(getPackageName());
        unit.addImport( "java.util.Date",
                String.format("%s.%s", ConvertsConstant.POJO_PACKAGE,this.getItem().getPojoClassName()),
                ConvertsConstant.CONVERT_COMMON_PACKAGE+".CommonData",
                "java.util.ArrayList","java.util.List","org.springframework.beans.factory.annotation.Autowired",
                ConvertsConstant.CONVERT_COMMON_PACKAGE+".CommonItemUtils",
                ConvertsConstant.CONVERT_COMMON_PACKAGE+".CommonItem",
                ConvertsConstant.CONVERT_COMMON_PACKAGE+".CommonItemUtils",
                "org.slf4j.Logger","org.slf4j.LoggerFactory")

        classBuildUtil.classInit(this.getClassName(),null,
                new String[]{String.format("CommonItemUtils<%s>",this.getItem().getPojoClassName())}, this.getPackageName(),null,true,
               );
    }

    @Override
    protected String getPackageName() {
        return ConvertsConstant.BASE_PACKAGE;
    }

    @Override
    public String getClassName(String name) {
        return StringUtil.firstUpper(name) +"CommonBase";
    }

}
