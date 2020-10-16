package com.mg.node.common.service.cache;

import com.esotericsoftware.minlog.Log;
import com.mg.node.common.service.cache.IBaseCache;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
public class CacheStore {

    static volatile Map<Class, CacheList> store = new ConcurrentHashMap<>();

    public static synchronized void add(Class pojoCl,IBaseCache cache)
    {
        if(cache==null||pojoCl==null)return;
        CacheList caches = store.get(pojoCl);

        if(caches==null)caches = new CacheList();
        caches.add(cache);
        store.put(pojoCl,caches);
    }


    protected IBaseCache getMaster(Class pojoCl)
    {
        CacheList caches = store.get(pojoCl);
        if(caches!=null)
        {
            return caches.master;
        }
        return null;
    }

    protected void lock(Class pojoCl,Object pojo) throws Exception {
        CacheList caches = store.get(pojoCl);
        if(caches!=null) {
            IBaseCache master = caches.master;
            if(master==null)
            {
                log.info("{}类型的缓存未设置Master,停止加锁,请检查配置！！",pojoCl.getSimpleName());
                return;
            }
            master.lock(pojo);


        }
    }

    protected void unlock(Class pojoCl,Object pojo) throws Exception {
        CacheList caches = store.get(pojoCl);
        if(caches!=null) {
            IBaseCache master = caches.master;
            if(master==null)
            {
                log.info("{}类型的缓存未设置Master,停止解锁,请检查配置！！",pojoCl.getSimpleName());
                return;
            }
             master.unlock(pojo);
        }
    }

    /**
     * 删除缓存 synDB控制是否同步到数据库当中
     * @param pojoCl
     * @param pojo
     * @param synDB  true 同步到数据库  false  不同步数据库
     */
    protected void delete(Class pojoCl,Object pojo,boolean synDB) {
        CacheList caches = store.get(pojoCl);
        IBaseCache master =null;
        if(caches!=null)
        {
            master = caches.master;

            if(master==null)
            {
                log.info("{}类型的缓存未设置Master,停止缓存删除操作,请检查配置！！",pojoCl.getSimpleName());
                return;
            }
            try {
                master.lock(pojo);
                if (synDB) {
                    try {
                        master.delete(pojo, synDB);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                for (IBaseCache cache : caches.all) {
                    try {
                        cache.delete(pojo, false);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            finally {
                try {
                    master.unlock(pojo);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 更新缓存  只更新缓存，不更新数据库
     * @param pojoCl
     * @param pojo
     */
    protected void update(Class pojoCl,Object pojo,boolean synDB) {
        CacheList caches = store.get(pojoCl);
        IBaseCache master =null;
        if(caches!=null)
        {
            master = caches.master;
            if(master==null)
            {
                log.info("{}类型的缓存未设置Master,停止缓存更新操作,请检查配置！！",pojoCl.getSimpleName());
                return;
            }
            try {
                master.lock(pojo);
                if (synDB) {
                    pojo = master.update(pojo, synDB);
                }

                for (IBaseCache cache : caches.all) {
                    try {
                        cache.update(pojo, false);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }finally {
                try {
                    master.unlock(pojo);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private static class CacheList
    {
        IBaseCache master = null;
        List<IBaseCache> all = new ArrayList<>();

        public void add(IBaseCache cache)
        {
            if(all.contains(cache))
            {
                log.info("{}缓存对象已添加过一次，不在重新添加至列表",cache);
                return;
            }

            if(cache.getMaster())
            {
                if(master!=null)
                {
                    log.info("{}已被作为Master对象，{}将覆盖Master设置",master,cache);
                }
                this.master = cache;
            }
            all.add(cache);
        }

    }


}
