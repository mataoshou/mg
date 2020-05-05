package com.mg.common.pojo;

import java.util.ArrayList;
import java.util.List;

public class MethodItem {

    /**
     * 函数类型  1 有body  2没有
     */
    private int type;
    /**
     * 返回结果
     */
    private String returnValue;

    /**
     * 函数名称
     */
    private String methodName;

    /**
     * 修饰
     */
    private String decorate;


    private List<ParamItem> params = new ArrayList();


    private List<LineItem> lines = new ArrayList<>();


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(String returnValue) {
        this.returnValue = returnValue;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getDecorate() {
        return decorate;
    }

    public void setDecorate(String decorate) {
        this.decorate = decorate;
    }

    public List<ParamItem> getParams() {
        return params;
    }

    public void setParams(List<ParamItem> params) {
        this.params = params;
    }

    public List<LineItem> getLines() {
        return lines;
    }

    public void setLines(List<LineItem> lines) {
        this.lines = lines;
    }

    public void addLine(String content,int interval)
    {
        addLine(content,interval,"  ");
    }



    public void addLine(String content,int interval,String intervalStr)
    {
        LineItem line = new LineItem();
        line.setContent(content);
        line.setIntervalStr(intervalStr);
        line.setIntervalNo(interval);

        addLine(line);
    }

    public void addLine(LineItem line)
    {
        this.lines.add(line);
    }
}
