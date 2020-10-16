package com.mg.node.common.plugin.param.util;

import com.mg.common.pojo.ResultItem;
import com.mg.common.util.ReflectUtil;
import com.mg.common.util.ResultItemUtil;
import com.mg.common.util.StringUtil;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.BiFunction;

@Slf4j
public class ParamsCheckUtil {

    public static boolean isNull(Object value,String paramName)  {
            if(value==null)return false;
            return true;
    }

    public static boolean isEmpty(Object value,String paramName)
    {
            if(value==null)return false;

            if(value instanceof String)
            {
                return StringUtil.isEmpty(value.toString());
            }

            if(value instanceof  Number)
            {
                return !(Integer.valueOf(value.toString())==0);
            }
            return true;
    }

    public static boolean defaultMethod(Object value,String paramName)
    {
        if(value==null)return false;
        return true;
    }

}
