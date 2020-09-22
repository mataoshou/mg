package com.mg.common.util;

public class ReflectUtil {
    //获取属性的get方法
    public static String getGetMethodName(String valueName)
    {
        char first = Character.toUpperCase(valueName.charAt(0));
        StringBuffer methodName = new StringBuffer("get" + valueName);
        methodName.setCharAt(3, first);

        return methodName.toString();
    }
    //获取属性的set方法
    public static String getSetMethodName(String valueName)
    {
        char first = Character.toUpperCase(valueName.charAt(0));
        StringBuffer methodName = new StringBuffer("set" + valueName);
        methodName.setCharAt(3, first);

        return methodName.toString();
    }
    //根据类型获取数据
    public static Object convertByType(Object value,Class type)
    {
        if(type.equals(int.class)||type.equals(Integer.class))
            return Integer.valueOf(value.toString());
        if(type.equals(long.class)||type.equals(Long.class))
            return Long.valueOf(value.toString());
        if(type.equals(double.class)||type.equals(Double.class))
            return Double.valueOf(value.toString());
        if(type.equals(float.class)||type.equals(Float.class))
            return Float.valueOf(value.toString());
        if(type.equals(short.class)||type.equals(Short.class))
            return Short.valueOf(value.toString());
        if(type.equals(boolean.class)||type.equals(Boolean.class))
            return Boolean.valueOf(value.toString());
        if(type.equals(String.class))
            return String.valueOf(value);
//		if(type.equals(Date.class))
//			return null;
        return null;
    }
}
