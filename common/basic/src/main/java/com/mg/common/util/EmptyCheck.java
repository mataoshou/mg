package com.mg.common.util;

public class EmptyCheck {

    public static boolean check(String str)
    {
        if(str==null||str.length()==0)
        {
            return false;
        }
        return true;
    }


    public static boolean check(Number no)
    {
        if(no==null||no.intValue()==0)
        {
            return false;
        }
        return true;
    }
}
