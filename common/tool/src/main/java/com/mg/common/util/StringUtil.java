package com.mg.common.util;

public class StringUtil {

    public static String firstUpper(String str)
    {
        char first = Character.toUpperCase(str.charAt(0));
        StringBuffer methodName = new StringBuffer(str);
        methodName.setCharAt(0, first);

        return methodName.toString();
    }
}
