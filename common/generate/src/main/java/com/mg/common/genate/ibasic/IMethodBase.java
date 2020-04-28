package com.mg.common.genate.ibasic;

import com.mg.common.util.Convert;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Slf4j
public abstract class IMethodBase {

    String name ;
    ParamItem returnParam;

    /**
     * 1完整函数  2 抽象函数  3 接口  4语句
     */
    int codeType =1;

    /**
     * 1 public 2 private 3 protected
     */
    int type =1;

    //函数参数
    Map<String,ParamItem> params = new TreeMap();

    //注解
    List<String> anntions = new ArrayList();

    ////外部结构
    String methodContent = "";

    ////内部结构
    private String innerContent = "";

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    public abstract void methodTemplate();


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public void initMethod(){

    }

    ////添加注解
    public void addAnntion(String...anntions)
    {
        for(String a : anntions) {
            this.anntions.add(a);
        }
    }

    public IMethodBase(String name,String returnName,Class returnClass)
    {
        this.name = name;
        setReturnParam(returnName,returnClass);
        initMethod();
    }


    //设置返回类型
    public void setReturnParam(String name,Class classType)
    {
        this.returnParam.name = name;
        this.returnParam.classType = classType;
    }

    //添加参数
    public void addParam(String pre, String paramName,Class paramType)
    {
        if(params.get(paramName)!=null)
        {
            log.info("已存在参数" + paramName);
        }

        ParamItem item = new ParamItem();
        item.name = name;
        item.pre = pre;
        item.classType = paramType;
        params.put(paramName,item);
    }


    public String finish()
    {
        buildFrameWork();
        return methodContent.replace("##2",innerContent);
    }

    /**
     * 构建空方法
     */
    private void buildFrameWork()
    {
        String decorate = "public";
        if(type == TYPE_PRIVATE){decorate="private";}

        if(codeType==4)
        {
            methodContent=addTabContent("##2");
            return;
        }

        Convert convert = new Convert();
        List<String> paramsKey = convert.keytoList(params);
        String paramContent ="";
        for(String key : paramsKey)
        {
            if(paramContent.length()>0)
            {
                paramContent += ",";
            }

            paramContent += String.format("%s %s",params.get(key).classType.getSimpleName(),key);
        }

        if(anntions!=null&&anntions.size()>0) {
            for (String anntion : anntions) {
                methodContent += addTabContent( "@" + anntion);
            }
        }

        if(codeType==1)
        {
            methodContent+=getContent(tab_no,tab,String.format("%s %s %s (%s){",decorate,returnParam.classType.getSimpleName(),name,paramContent));
            methodContent+=addTabLeftContent("##2");
            methodContent+=addTabRightContent("}");
        }else if(codeType==2)
        {
            methodContent+=addTabContent(String.format("%s %s %s (%s);",decorate,returnParam.classType.getSimpleName(),name,paramContent));
        }else if(codeType==3)
        {
            methodContent+=addTabContent(String.format("%s abstract %s %s (%s);",decorate,returnParam.classType.getSimpleName(),name,paramContent));
        }
    }

    public void addEmpty()
    {
        if(returnParam.classType.equals(void.class)||returnParam.classType.equals(Void.class))
        {
            addTabContent(" ");
        }
        else {
            addTabContent("return null;");
        }
    }


    public final static int TYPE_PUBLISH = 1;
    public final static int TYPE_PRIVATE = 2;


    int tab_no = 1;

    String tab ="   ";

    /**
     * tab 间隔不变  增加类内容
     * @param line
     */
    public String  addTabContent(String line)
    {
        return getContent(tab_no,tab,line);
    }


    /**
     * tab 间隔加1  增加类内容
     * @param line
     */
    public String addTabRightContent(String line)
    {
        tab_no++;

        return addTabContent(line);
    }
    /**
     * tab 间隔减1  增加类内容
     * @param line
     */
    public String addTabLeftContent(String line)
    {
        tab_no--;

        return addTabContent(line);
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

    class ParamItem
    {
        String name;
        String pre;

        Class classType;
    }

}
