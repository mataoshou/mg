package com.mg.node.common.plugin.mybatis.produce;

import ch.qos.logback.classic.db.names.ColumnName;
import com.mg.node.common.plugin.mybatis.annotations.Column;
import com.mg.node.common.plugin.mybatis.annotations.PrimaryId;
import com.mg.node.common.plugin.mybatis.annotations.Table;
import com.mg.node.common.util.SqlWhere;
import com.mg.node.common.util.ToolHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.xml.XmlBeanFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class SqlFactory {
    public String insertItem(Map<String,Object> para) throws Exception {
        return buildInsertSql(para.get("pojoItem"));
    }

    /**
     * 构建动态insert语句
     * @param item
     * @return
     * @throws Exception
     */
    public String buildInsertSql(Object item) throws Exception {
        Class cls = item.getClass();
        //得到所有属性
        Field[] fields = cls.getDeclaredFields();
        Map<String,String> params = new HashMap();
        for(Field f : fields)
        {
            f.setAccessible(true);
            Object value = f.get(item);

            String name = f.getName();
            Column ca = f.getDeclaredAnnotation(Column.class);
            if(ca!=null)
            {
                if(ca.ingore())continue;
                name = ca.cloumn();
            }
            if(value!=null)
            {
                params.put(name, value.toString());
            }
        }
        String keys ="";
        String values ="";
        for(Map.Entry entry: params.entrySet()){
            if(keys.length()>0)keys+=",";
            if(values.length()>0)values+=",";
            keys+=String.format("`%s`", entry.getKey());
            values+=String.format("'%s'", entry.getValue());
        }


        String sql = String.format("insert into `%s`(%s) values (%s);",
                ToolHolder.daoUtils.getTableName(item.getClass()),keys,values) ;
        log.info("执行insert语句：{}",sql.toString() );

        return sql;
    }

    public String updateItem(Map<String,Object> para) throws Exception {
        return buildUpdateSql(para.get("pojoItem"));
    }


    /**
     * 构建动态 update 语句
     * @param item
     * @return
     * @throws Exception
     */
    public String buildUpdateSql(Object item) throws Exception {
        Class cls = item.getClass();

        String sql = "";
        //得到所有属性
        Field[] fields = cls.getDeclaredFields();

        Map<String,String> params = new HashMap();
        String idName ="id";
        Object idValue =null;
        for(Field f : fields)
        {
            Column ca = f.getDeclaredAnnotation(Column.class);
            PrimaryId primaryId = f.getDeclaredAnnotation(PrimaryId.class);
            f.setAccessible(true);
            Object value = f.get(item);

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
                continue;
            }

            if(value!=null)
            {
                params.put(cloumnName, value.toString());
            }
        }
        for(Map.Entry entry: params.entrySet()){
            if(sql.length()>0)sql+=",";
            sql+=String.format("`%s`='%s'", entry.getKey(),entry.getValue());
        }

        if(sql.equals(""))
        {
            throw new Exception("对象没有可以更新的数据！！");
        }

        sql = String.format("UPDATE %s SET %s WHERE %s='%s'",
                ToolHolder.daoUtils.getTableName(item.getClass()),sql,idName,idValue) ;

        log.info("执行update语句：{}",sql.toString() );

        return sql;
    }


    /**
     * 构建动态查询条件
     * @param para
     * @return
     * @throws Exception
     */
    public String selectItem(Map<String,Object> para) throws Exception {
        Map<String,Object> params = (Map<String, Object>) para.get("params");

        Class itemcl = (Class) para.get("item");

        SqlWhere where = new SqlWhere();

        for(Map.Entry<String,Object> entry : para.entrySet())
        {
            where.add2(entry.getKey(),entry.getValue().toString());
        }
        Table table = (Table) itemcl.getDeclaredAnnotation(Table.class);
        String sql = String.format("SELECT * FROM %s WHERE %s ",table.value(),where);

        return sql;
    }

}
