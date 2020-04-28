package com.mg.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@slf4j
public class MethodUtil {
    String mehodContent ="";
    String innerContent ="";

    String methodName ="";

    String returnParam ="";


    Map<String,String> params = new TreeMap();


    public void addReturnParam(String returnParam)
    {
        this.returnParam = returnParam;
    }

    public void addParam(String paramName,Class paramType)
    {
        if(params.get(paramName)!=null)
        {
            log.info("已存在参数" + paramName);
        }
        params.put(paramName,paramType.getSimpleName());
    }

    public void methodInit()
    {
        methodInit(methodName,1,returnParam,null);
    }

    /**
     * 构建空方法
     * @param methodName
     * @param type
     * @param returnParam
     */
    public void methodInit(String methodName,int type ,String returnParam,String[] anntions)
    {

        String decorate = "public";
        if(type == TYPE_PRIVATE){decorate="private";}
        Convert convert = new Convert();
        List<String> paramsKey = convert.keytoList(params);
        String paramContent ="";
        for(String key : paramsKey)
        {
            if(paramContent.length()>0)
            {
                paramContent += ",";
            }

            paramContent += String.format("%s %s",params.get(key),key);
        }

        if(anntions!=null&&anntions.length>0) {
            for (String anntion : anntions) {
                mehodContent += getContent(tab_no, tab, "@" + anntion);
            }
        }
        mehodContent+=getContent(tab_no,tab,String.format("%s %s %s (%s){",decorate,returnParam,methodName,paramContent));

        tab_no++;
        mehodContent+=getContent(tab_no,tab,"##2");

        tab_no--;
        mehodContent+=getContent(tab_no,tab,"}");

    }

    public void addEmpty()
    {


        if(returnParam.equals("void")||returnParam.equals("Void"))
        {
            addTabContent(" ");
        }
        else {
            addTabContent("return null;");
        }
    }


    public String methodToString()
    {
        return  mehodContent.replace("##2",innerContent);
    }


    public final static int TYPE_PUBLISH = 1;
    public final static int TYPE_PRIVATE = 2;


    int tab_no = 1;

    String tab ="   ";

    /**
     * tab 间隔不变  增加类内容
     * @param line
     */
    public void  addTabContent(String line)
    {
        innerContent += getContent(tab_no,tab,line);
    }


    /**
     * tab 间隔加1  增加类内容
     * @param line
     */
    public void addTabRightContent(String line)
    {
        tab_no++;

        addTabContent(line);
    }
    /**
     * tab 间隔减1  增加类内容
     * @param line
     */
    public void addTabLeftContent(String line)
    {
        tab_no--;

        addTabContent(line);
    }


    private String getContent(int tab_no,String tab,String content)
    {
        String tabs="";
        for(int i=0;i<tab_no;i++)
        {
            tabs+=tab;
        }
        return tabs+content+"\r";
    }

}
