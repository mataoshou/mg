package com.mg.node.frame.init;

import com.mg.node.frame.produce.ProduceStore;

import java.io.IOException;

public abstract class MgAbstractInitializing {


    public abstract void setConfig()throws Exception;

    /**
     * 添加新的pojo
     * @param pojo
     */
    protected void addPojo(Class pojo){
        ProduceStore.single().addPojo(pojo);
    }

    /**
     * 添加新的pojo
     * @param pojo
     * @param template
     * @param imp
     */
    protected void addPojo(Class pojo,Class template,Class imp){
        ProduceStore.single().addPojo(pojo,template,imp);
    }

    /**
     * 添加扫描包
     * @param packageName
     * @throws Exception
     */
    protected void addPackage(String packageName) throws Exception{
        ProduceStore.single().addPackage(packageName);
    }

    /**
     * 添加扫描包
     * @param packageName
     * @param template
     * @param imp
     * @throws Exception
     */
    protected void addPackage(String packageName,Class template,Class imp) throws Exception{
        ProduceStore.single().addPackage(packageName,template,imp);
    }


}
