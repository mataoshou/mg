package com.mg.node.common.plugin.mybatis.util;

import com.mg.node.common.plugin.mybatis.annotations.Column;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import com.mg.node.common.plugin.mybatis.pojo.SimpleItem;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PojoUtil {

    public SimpleItem getPrimaryId(Object pojo) throws IllegalAccessException {
        Class cls = pojo.getClass();

        String idName ="id";
        Object idValue =null;
        //得到所有属性
        Field[] fields = cls.getDeclaredFields();
        for(Field f : fields)
        {
            Column ca = f.getDeclaredAnnotation(Column.class);
            PrimaryId primaryId = f.getDeclaredAnnotation(PrimaryId.class);
            f.setAccessible(true);
            Object value = f.get(pojo);

            String cloumnName = f.getName();

            if(ca!=null)
            {
                if(ca.ingore())continue;
                cloumnName = ca.cloumn();
            }

            if(primaryId!=null)
            {
                idName = cloumnName;
                idValue = value;
                break;
            }
        }
        SimpleItem item = new SimpleItem();
        item.setColumnName(idName);
        item.setValue(idValue.toString());
        return item;
    }

    public Map<String,String> getColumnMap(Object pojo) throws IllegalAccessException {
        Class cls = pojo.getClass();

        String sql = "";
        //得到所有属性
        Field[] fields = cls.getDeclaredFields();

        Map<String,String> params = new HashMap();
        for(Field f : fields)
        {
            Column ca = f.getDeclaredAnnotation(Column.class);
            f.setAccessible(true);
            Object value = f.get(pojo);

            String cloumnName = f.getName();

            if(ca!=null)
            {
                if(ca.ingore())continue;
                cloumnName = ca.cloumn();
            }

            if(value!=null)
            {
                if(value instanceof Date)
                {
                    params.put(cloumnName, getDateString(value));
                }
                else {
                    params.put(cloumnName, value.toString());
                }
            }
        }
        return params;
    }

    public String getDateString(Object value)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(value);
        return dateString;
    }

}
