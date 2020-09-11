package com.mg.node.common.plugin.generate.db;

import com.mg.common.plugin.igenerate.ICreate;
import com.mg.common.unit.ClassUnit;
import com.mg.common.unit.MethodUnit;
import com.mg.common.util.DomUtil;
import com.mg.common.util.FileStore;
import com.mg.common.util.StringUtil;
import com.mg.node.common.config.DaoConfiguration;
import com.mg.node.common.constant.DBConstant;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CreateExternMapperXML extends ICreate {


    public CreateExternMapperXML(String name) {
        super(name, null);
    }


    @Override
    public void startCreate() throws IOException {
        build();
    }


    @Override
    public void startEdit() throws IOException {
        build();
    }


    public void build()
    {
        String mergeFileName = "I" + this.getName() + "Mapper";


        File baseMapperFile = new File(this.getClassFile().getParentFile(),this.getName()+"MapperBase.xml");


        String content = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\" >\n" +
                String.format("<mapper namespace=\"%s.##1\" >\n", DBConstant.DB_MERGEDAO_PACKAGE) +
                "    <select id=\"list\" resultMap=\"BaseResultMap\" >\n" +
                "        select\n" +
                "        <include refid=\"Base_Column_List\" />\n" +
                "        from ##2\n" +
                "        <if test=\"where != null\">\n" +
                "         where ${where}\n" +
                "        </if>\n" +
                "        <if test=\"order != null\">\n" +
                "            order by ${order}\n" +
                "        </if>\n" +
                "    </select>\n" ;

        DomUtil domUtil = new DomUtil();
        Document document = null;
        try {
            document = domUtil.getDocument(baseMapperFile);
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }

        Element element = document.getRootElement().element("resultMap");

        List<Element> eles = element.elements();


        String insert_keys="";
        String insert_value="";

        String itemName ="";
        for (Element ele : eles) {
            String column = ele.attributeValue("column");
            String jdbcType = ele.attributeValue("jdbcType");
            String property = ele.attributeValue("property");
            if(itemName.length()==0&&(column.indexOf("name")>0||column.indexOf("Name")>0))
            {
                itemName=column;
            }

            insert_keys += column+",";
            insert_value += String.format("#{%s,jdbcType=%s},",property,jdbcType);
        }
        insert_keys = insert_keys.substring(0,insert_keys.length()-1);
        insert_value = insert_value.substring(0,insert_value.length()-1);


        String selectByName = "";
        if(itemName.length()>0)
        {
            selectByName ="    <select id=\"selectByName\" resultMap=\"BaseResultMap\" parameterType=\"java.lang.String\" >\n" +
                    "        select\n" +
                    "        <include refid=\"Base_Column_List\" />\n" +
                    "        from ##2 \n" +
                    "        where ##3 = #{name,jdbcType=VARCHAR}\n" +
                    "    </select> \n";
        }

        String getByWhere =
                String.format("    <select id=\"get\" resultMap=\"BaseResultMap\" parameterType=\"java.lang.String\" >\n" +
                        "        select\n" +
                        "        <include refid=\"Base_Column_List\" />\n" +
                        "        from ##2\n" +
                        "        where ${where}\n" +
                        "    </select>\n");

        content += getByWhere;

        String insertByCustomId = "    <insert id=\"insertByCustomId\"   parameterType=\"##4\" >\n" +
                "        insert into ##2 (##5)\n" +
                "        values (##6)\n" +
                "    </insert>\n";

        content +=selectByName;
        content +=insertByCustomId;
        content +="</mapper>";

        DaoConfiguration configuration = new DaoConfiguration();
        String tableName = configuration.daoUtilsBean().getTableName(this.getName());


        content = content.replace("##1", mergeFileName).replace("##2", tableName).replace("##3",itemName)
                .replace("##4",String.format("%s.%s",DBConstant.DB_POJO_PACKAGE, this.getName())).replace("##5",insert_keys).replace("##6",insert_value);
        FileStore.putString(this.getClassFile(), content, "UTF-8");
    }



    @Override
    protected String getPackageName() {
        return DBConstant.DB_XML_MAPPER_PACKAGE;
    }

    @Override
    public String getClassName(String name) {
        return StringUtil.firstUpper(name) +"MapperExtern";
    }



    @Override
    protected String getSuffix() {
        return "xml";
    }

    @Override
    protected void createPre(ClassUnit unit) throws IOException {

    }

    @Override
    protected void createPreEachMethod(MethodUnit munit) throws IOException {

    }

    @Override
    protected void createMethod(MethodUnit unit) throws IOException {

    }

    @Override
    protected void classInit(ClassUnit unit) {

    }
}
