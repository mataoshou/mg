package com.mg.common.util;

import com.esotericsoftware.minlog.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringUtil {

    public static String firstUpper(String str)
    {
        char first = Character.toUpperCase(str.charAt(0));
        StringBuffer methodName = new StringBuffer(str);
        methodName.setCharAt(0, first);

        return methodName.toString();
    }

    public static String connect(String s1,String s2,String intrerval)
    {
        return s1 + intrerval + s2;
    }

    public static String addUnEmpty(String str ,String pre,String last)
    {
        if(isEmpty(str)) return "";
        if(!isEmpty(pre))str = pre+str;
        if(!isEmpty(last))str = str +last;

        return str;
    }

    public static boolean isEmpty(String str)
    {
        return str==null||str.length()==0;
    }

    public static String connect(String[] strs ,String pre,String last,String intrerval)
    {
        if(strs==null||strs.length==0)
        {
            return null;
        }
        if(pre==null)pre="";
        if(last==null)last="";
        if(intrerval==null)
        {
            log.info("intrerval参数为null,替换为默认值，");
            intrerval=",";
        }
        String result ="";
        for(String str : strs)
        {
            if(result.length()>0)result+=intrerval;
            result += String.format("%s%s%s",pre,str,last);
        }
        return result;
    }
}
