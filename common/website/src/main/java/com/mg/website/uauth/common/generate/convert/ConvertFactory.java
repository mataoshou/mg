package com.mg.website.uauth.common.generate.convert;

import com.mg.common.iservice.ibasic.IFactory;
import com.mg.common.util.BaseFileUtil;
import com.mg.common.util.CommonTool;
import com.mg.website.uauth.common.constant.ConvertsConstant;

import java.io.File;

public class ConvertFactory extends IFactory {

    public ConvertFactory() {
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

}
