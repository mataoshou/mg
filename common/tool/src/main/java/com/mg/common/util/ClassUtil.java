package com.mg.common.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
public class ClassUtil {


    String innerContent = "";

    /**
     * tab 间隔不变  增加类内�?
     * @param line
     */
    public void  addTabContent(String line)
    {
        innerContent += getContent(tab_no,tab,line);
    }


    /**
     * tab 间隔�?1  增加类内�?
     * @param line
     */
    public void addTabRightContent(int tab_no,String tab,String line)
    {
        tab_no++;

        addTabContent(line);
    }
    /**
     * tab 间隔�?1  增加类内�?
     * @param line
     */
    public void addTabLeftContent(int tab_no,String tab,String line)
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
