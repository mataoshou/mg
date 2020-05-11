package com.mg.common.util;

public class ClassUtil {

    /**
     * 获取属性的get方法
     */
    public static String getGetMethodName(String valueName)
    {
        char first = Character.toUpperCase(valueName.charAt(0));
        StringBuffer methodName = new StringBuffer("get" + valueName);
        methodName.setCharAt(3, first);

        return methodName.toString();
    }


    /**
     * 获取属性的set方法
     */
    public static String getSetMethodName(String valueName)
    {
        char first = Character.toUpperCase(valueName.charAt(0));
        StringBuffer methodName = new StringBuffer("set" + valueName);
        methodName.setCharAt(3, first);

        return methodName.toString();
    }
}
