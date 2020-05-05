package com.mg.common.genate.mgconvert;

import com.shineon.db.common.base.util.DomUtil;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ConvertTools {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public List<PropertyItem> getItems(Class cl)
    {
        Field[] fs = cl.getDeclaredFields();
        logger.debug(cl.getName() +"  属性数量："+fs.length);

        List<PropertyItem> list = new ArrayList<>();

        for(Field f:fs)
        {
//            System.out.println(f.getName());
            PropertyItem item = new PropertyItem();
            item.name = f.getName();
            item.type = f.getType().getName();
            item.status = false;

            list.add(item);
        }

        return  list;
    }

    //获取原来的映射关系
    public List<MapperItem> getMapper(File file) throws IOException, DocumentException {

        DomUtil dom = new DomUtil();

        Document doc = dom.getDocument(file);
        List<MapperItem> list = new ArrayList<>();
        Element root =  doc.getRootElement();
        List<Element> eles = root.elements();
        for(Element ele :eles)
        {
            MapperItem item = new MapperItem();
            item.commonName = ele.attributeValue("commonName").trim();
            item.pojoName = ele.attributeValue("pojoName").trim();
            item.type = ele.attributeValue("type").trim();
            item.status = true;
            list.add(item);
        }

        return list;
    }



    public PropertyItem getItem(PropertyItem item, List<PropertyItem> items)
    {
        for(PropertyItem ci:items)
        {
            if(ci.status)continue;;

            if(ci.name.equals(item.name)&&ci.type.equals(item.type)) {

                return ci;
            }
        }

        PropertyItem result = getSimaliar(item,items);

        return  result;
    }

    public PropertyItem getFirstType(PropertyItem item, List<PropertyItem> items)
    {

        for(PropertyItem ci:items)
        {
            if(ci.status)continue;;
            if(ci.type.equals(item.type)) {

                return ci;
            }
        }

        return  null;
    }

    public PropertyItem getSimaliar(PropertyItem item, List<PropertyItem> items)
    {
        int score = 0;
        PropertyItem result =null;
        for(PropertyItem ci:items)
        {
            if(ci.status)continue;;
            if(ci.type.equals(item.type)) {

               int count = getScore(item.name,ci.name);
               if(score<count)
               {
                   score = count;
                   result = ci;
               }
            }
        }

        return result;
    }

    public int getScore(String str , String next)
    {
        char[] chs = str.toCharArray();

        int score = 0;

        for(char c : chs)
        {
            if(next.indexOf(c)>0)
            {
                score++;
            }
        }

        return  score;
    }

    public  String getFileName(String fn)
    {

        String name =  fn.substring(0,fn.lastIndexOf(".") );

        return name;
    }
}
