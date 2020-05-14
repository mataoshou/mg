package com.mg.website.uauth.common.generate.convert;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Date;

public class ConvertTools {

    public static Field[] getFields(Class cl)
    {
        Field[] fs = cl.getDeclaredFields();
        return  fs;
    }


    public static String getFileName(String fn)
    {

        String name =  fn.substring(0,fn.lastIndexOf(".") );

        return name;
    }


    public static String getMethod(Field field)
    {
        Type type = field.getType();
        if(type.equals(int.class)||type.equals(Integer.class)) {
            return "getInteger";
        }
        if(type.equals(long.class)||type.equals(Long.class)) {
            return "getLong";
        }
        if(type.equals(double.class)||type.equals(Double.class)) {
            return "getDouble";
        }
        if(type.equals(String.class)) {
            return "getString";
        }
        if(type.equals(Date.class)) {
            return "getDate";
        }

        return "getObject";

    }
}
