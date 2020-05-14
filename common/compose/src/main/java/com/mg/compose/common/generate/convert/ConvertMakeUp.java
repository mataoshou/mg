package com.mg.compose.common.generate.convert;

import com.mg.common.iservice.ibasic.IMakeUpBase;
public class ConvertMakeUp extends IMakeUpBase {


    public ConvertMakeUp(String name, Class pojoClass) {

        add( new CreateConvertBase(name,pojoClass));
        add( new CreateConvertUtil(name));
    }

}
