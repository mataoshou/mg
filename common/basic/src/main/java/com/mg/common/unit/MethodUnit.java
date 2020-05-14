package com.mg.common.unit;

import com.mg.common.pojo.LineItem;
import com.mg.common.pojo.MethodItem;
import com.mg.common.pojo.ParamItem;
import com.mg.common.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class MethodUnit {

    /////////////////////////////////////////////////////////////////////////////

    public final static String TYPE_PUBLISH = "publish";
    public final static String TYPE_PRIVATE = "private";


    public final static int METHOD_TYPE_NORMAL = 1;
    public final static int METHOD_TYPE_ABSTRACT = 2;

    /////////////////////////////////////////////////////////////////////////////


    private boolean isUsed = true;

    private List<LineItem> preLine = new ArrayList<>();


    public void setDisabled()
    {
        isUsed =false;
    }

    public void addPreLine(String lineStr)
    {
        LineItem lineItem = new LineItem();
        lineItem.setIntervalNo(1);
        lineItem.setContent(lineStr);
        preLine.add(lineItem);
    }

    private MethodItem methodItem = new MethodItem();


    public MethodItem getMethodItem()
    {
        return methodItem;
    }


    public String getName()
    {
        return this.methodItem.getMethodName();
    }


    public void setName(String name)
    {
        this.methodItem.setMethodName(name);
    }

    public void setType(int mType)
    {
        this.methodItem.setType(mType);
    }

    public void setDecorate(String decorate)
    {
        this.methodItem.setDecorate(decorate);
    }

    public void setReturnValue(String returnValue)
    {
        this.methodItem.setReturnValue(returnValue);
    }

    public void addParam(String pType,String pName)
    {
        this.methodItem.addParam(pType,pName);
    }


    public void addLine(LineItem line)
    {
        this.methodItem.addLine(line);
    }

    public void addAnnotation(String annotation)
    {
        this.methodItem.addAnnotation(annotation);
    }

    public void addException(String ex)
    {
        this.methodItem.addException(ex);
    }


    public String getPre()
    {
        String pre = "";

        for(LineItem item : preLine)
        {
            pre +=item.buildContent();
        }
        return pre;
    }

    public String getContent()
    {
        if(!isUsed)
        {
            return "";
        }

        String content =template();
        if(this.methodItem.getType()==2)
        {
            content = templateNobody();
        }

        String anntions = "";

        for(String ann : this.methodItem.getAnnotations())
        {
            anntions += "@"+ann+"\n";
        }

        if(anntions.length()==0)
        {
            anntions="\n";
        }

        String params = "";

        for(ParamItem item : this.methodItem.getParams())
        {
            if(params.length()>0)
            {
                params +=",";
            }
            params += String.format("%s %s",item.getKey(),item.getValue());
        }

        String inner ="";

        for(LineItem line : this.methodItem.getLines())
        {
            inner+= line.buildContent() ;

        }

        String ex ="";

        for(String e : this.methodItem.getExceptions())
        {
            if(ex.length()>0)
            {
                ex +=",";
            }
            else {
                ex = "throws ";
            }
            ex+= e ;

        }

        content = content
                .replace("#decorate#",this.methodItem.getDecorate())
                .replace("#returnType#",StringUtil.addUnEmpty(this.methodItem.getReturnValue()," "," "))
                .replace("#params#",params)
                .replace("#content#",inner)
                .replace("#methodName#",this.methodItem.getMethodName())
                .replace("#anntion#",anntions)
                .replace("#exception#",StringUtil.addUnEmpty(ex," ",""));


        return content;

    }


    public String template()
    {
        String classTemplate =
                "   #anntion#"+
                "   #decorate##returnType##methodName#(#params#)#exception#{" +"\r\n"+
                "#content#"+
                "   }\n";

        return classTemplate;
    }

    public String templateNobody()
    {
        String classTemplate =
                "   #anntion#"+
                "   #decorate##returnType##methodName#(#params#);" +"\r\n";

        return classTemplate;
    }


    private void addLine(String lineStr,int index)
    {
        int no = 2;
        int size = this.methodItem.getLines().size();
        if(size>0)
        {
            no = this.methodItem.getLines().get(size-1).getIntervalNo();
        }
        LineItem lineItem = new LineItem();
        lineItem.setIntervalNo(no + index);
        lineItem.setContent(lineStr);
        this.methodItem.addLine(lineItem);
    }

    /**
     * tab 间隔不变  增加代码行
     * @param lineStr
     */
    public void  addTabContent(String lineStr)
    {
        addLine(lineStr,0);
    }

    /**
     * tab 间隔加1 增加代码行
     * @param lineStr
     */
    public void addTabRightContent(String lineStr)
    {
        addLine(lineStr,1);
    }

    /**
     * tab 间隔减1  增加代码行
     * @param lineStr
     */
    public void addTabLeftContent(String lineStr)
    {
        addLine(lineStr,-1);
    }
}
