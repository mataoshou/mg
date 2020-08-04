package com.mg.node.dao;

import com.mg.node.common.util.DaoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public abstract class SuperDao<T,M> {

    public abstract T getById(M id);

    @Autowired
    DaoUtils daoUtils;

    public String buildUpdateSql(T t,M id) throws Exception {
        Class cls = t.getClass();

        String sql = "";
        //得到所有属性
        Field[] fields = cls.getDeclaredFields();

        Map<String,String> params = new HashMap();

        for(Field f : fields)
        {
            Object value = f.get(t);

            if(value!=null)
            {
                params.put(f.getName(), value.toString());
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

        sql = String.format("UPDATE %s SET %s WHERE %s='%s'", daoUtils.getTableName(t.getClass()),sql,getKeyName(),id) ;

        log.debug("sql:"+sql);

        return sql;
    }


    public String buildInsertByCustomIdSql(T t) throws Exception {
        Class cls = t.getClass();
        //得到所有属性
        Field[] fields = cls.getDeclaredFields();

        Map<String,String> params = new HashMap();

        for(Field f : fields)
        {
            Object value = f.get(t);

            if(value!=null)
            {
                params.put(f.getName(), value.toString());
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

        if(keys.equals("")||values.equals(""))
        {
            throw new Exception("对象没有可以插入的数据！！");
        }

        String sql = String.format("insert  into `%s`(%s) values (%s);", daoUtils.getTableName(t.getClass()),keys,values) ;
        log.debug("sql:"+sql);

        return sql;
    }


    public String buildInsertSql(T t) throws Exception {
        Class cls = t.getClass();
        //得到所有属性
        Field[] fields = cls.getDeclaredFields();

        Map<String,String> params = new HashMap();

        for(Field f : fields)
        {
            f.setAccessible(true);
            Object value = f.get(t);

            if(value!=null&&!f.getName().equals(getKeyName()))
            {
                params.put(f.getName(), value.toString());
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

        if(keys.equals("")||values.equals(""))
        {
            throw new Exception("对象没有可以插入的数据！！");
        }

        String sql = String.format("insert  into `%s`(%s) values (%s);", daoUtils.getTableName(t.getClass()),keys,values) ;
        log.info("sql:"+sql);

        return sql;
    }



    public String getKeyName(){
        return "id";
    }


}
