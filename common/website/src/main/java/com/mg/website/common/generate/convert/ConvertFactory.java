package com.mg.website.common.generate.convert;

import com.mg.common.iservice.ibasic.IFactory;
import com.mg.common.util.BaseFileUtil;
import com.mg.common.util.CommonTool;
import com.mg.website.common.constant.ConvertsConstant;
import com.mg.website.common.constant.SysConstant;

import java.io.File;
import java.io.IOException;
import java.rmi.server.ExportException;

public class ConvertFactory extends IFactory {

    public ConvertFactory(String name,   String[] methods, String sysName) {
        super(name);
        setMakeUp();
    }

    public void setMakeUp() {
        CommonTool tools = new CommonTool();
        File root = tools.getSysPath(ConvertsConstant.POJO_PACKAGE);
        File[] pojos = root.listFiles();

        for(File pf :pojos) {
            try {
                String fname = BaseFileUtil.getFileNameNoSuffix(pf.getName());
                String pojoClassName = ConvertsConstant.POJO_PACKAGE + "." + fname;
                Class pojoClass = Class.forName(pojoClassName);
                ConvertMakeUp makeUp = new ConvertMakeUp(fname, pojoClass);
                addMakeUp(makeUp);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void build() throws Exception {

    }

    @Override
    public void rebuild() throws Exception {
        build();
    }

}