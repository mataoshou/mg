package com.mg.node.service.cache;

import com.mg.node.common.service.cache.IBaseCache;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheStore {

    static Map<Class, List<IBaseCache>> store = new HashMap<>();

    public void add(Class pojo,IBaseCache cache)
    {
        List list = store.get(pojo);
        if(list==null||!list.contains(cache))
        {
            if(list==null)list = new ArrayList();
            list.add(cache);
            store.put(pojo,list);
        }
    }

    public void delete(Class pojoCl,Object pojo) throws Exception {
        List<IBaseCache> list = store.get(pojo);
        if(list!=null)
        {
            for(IBaseCache cache : list)
            {
                cache.delete(cache.getId(pojo));
            }
        }
    }

    public void update(Class pojoCl,Object pojo) throws Exception {
        List<IBaseCache> list = store.get(pojo);
        if(list!=null)
        {
            for(IBaseCache cache : list)
            {
                cache.update(pojo);
            }
        }
    }

}
