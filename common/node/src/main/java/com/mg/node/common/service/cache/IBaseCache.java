package com.mg.node.common.service.cache;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.node.POJONode;
import com.mg.common.pojo.ResultItem;
import com.mg.node.common.constant.CacheConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.bcel.generic.POP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;


/**
 * 缓存的基础类
 * 待改进部分  缓存的删除和编辑
 * @param <POJO>
 */
@Slf4j
public abstract class IBaseCache<POJO,IdType,QueryParam>{


    @Autowired
    public CacheStore store;

    @Autowired
    CacheUtil util;

    ///////////////////////////////////////////////////常量区////////////////////////////////////////////////////////
    String cachePre = "";
    String cacheLast = "";

    private long liveTime = CacheConstant.CACHE_LIVE;

    public void setLiveTime(long live)
    {
        liveTime = live;
    }

    String list_sign = CacheConstant.CACHE_DATE_LIST_SIGN;

    String pojo_sign = CacheConstant.CACHE_DATE_POJO_SIGN;

    public void setListSign(String list_sign) {
        this.list_sign = list_sign;
    }

    public void setPojoSign(String pojo_sign) {
        this.pojo_sign = pojo_sign;
    }

    private Class<POJO> pojoCl;

    private boolean isMaster = false;

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /////////////////////////////////////  自定义区域  ////////////////////////////////////////////////////////////


//    /**
//     * 缓存中没有数据，从数据库中获取 单个数据
//     * @return
//     */
//    protected abstract PoPOJO getPojo(String id);


    /**
     * 缓存中没有数据，从数据库中获取 单个数据
     * @return
     */
    protected abstract POJO getByDB(QueryParam param);

    /**
     * 缓存中没有数据，从数据库中获取 单个数据
     * @return
     */
    protected abstract POJO updateDB(POJO pojo);

    /**
     * 缓存中没有数据，从数据库中获取 单个数据
     * @return
     */
    protected abstract void deleteDB(QueryParam param);

    /**
     * 获取 缓存条件 id
     * @param pojo
     * @return
     */
    public abstract IdType getId(POJO pojo);


    /**
     * 获取 缓存条件 id
     * @param pojo
     * @return
     */
    public abstract QueryParam getQueryParam(POJO pojo);


    /**
     * 根据缓存规则查询构建查询pojo
     * @param params
     * @return
     */
    public abstract POJO buildQuery(QueryParam params);

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

   //////////////////////////////////////////初始化区域/////////////////////////////////////////////////////////////

    /**
     * 设置修饰词
     */
    protected void setCacheDecorate(String _cachePre,String _cacheLast,Class<POJO> pojoClass)
    {
        this.cachePre =_cachePre;
        this.cacheLast = _cacheLast;
        this.pojoCl = pojoClass;
    }

    protected void setMaster()
    {
        this.isMaster = true;
    }

    protected boolean getMaster()
    {
        return isMaster;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /////////////////////////////////////////操作区域//////////////////////////////////////////////////////////////

    /**
     * 获取缓存数据
     * 私有方法，不对外开放
     */
    public POJO get(QueryParam param) throws Exception {
        String key = getKey(param);

        POJO pojo = util.get(key,pojoCl);
        if(pojo==null)
        {
            pojo = operByLock(buildQuery(param),false,this::getData);
        } else {
            util.expire(key,liveTime);
        }
        return pojo;
    }

    public POJO getData(POJO pojo,boolean synDB)  {
        pojo = getByDB(getQueryParam(pojo));
        update(pojo,false);
        return pojo;
    }

    /**
     * 获取缓存列表数据
     * @param ukeys
     * @return
     * @throws Exception
     */
    public final List<POJO> getListCache(List<QueryParam> ukeys) throws Exception {

        List<POJO> list = new ArrayList();
        for(QueryParam ukey:ukeys)
        {
            list.add(get(ukey));
        }
        return list;
    }

    /**
     * 删除单个pojo的缓存
     */
    public boolean delete(POJO pojo,boolean synDB)  {
//        deleteListKeys();
        String rkey = getKey(getQueryParam(pojo));
        util.delete(rkey);
        if(synDB)
        {
            deleteDB(getQueryParam(pojo));
        }
        return true;
    }

    /**
     * 删除单个pojo的缓存
     */
    public final void delete(QueryParam param) throws Exception {
        POJO pojo = get(param);
        store.delete(pojoCl,pojo,true);
    }

    /**
     * 删除所有列表数据的缓存
     * 私有方法，不对外开放
     */
    private void deleteListKeys()
    {
        String keyPattern =  cachePre + "." + list_sign +"*";
        log.info("清理列表数据：" + keyPattern);
        util.deleteKeys(keyPattern);
    }

    /**
     * 更新缓存 删除数据,然后更新数据
     * @return
     */
    public final POJO update(POJO pojo) throws Exception {
        try {
            store.lock(pojoCl,pojo);
            store.delete(pojoCl, pojo, false);
            store.update(pojoCl, pojo, true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            store.unlock(pojoCl,pojo);
        }
        return get(getQueryParam(pojo));
    }


    /**
     *缓存单个pojo数据
     */
    protected final POJO update(POJO pojo,boolean synDB ){

//        delete(pojo,false);
        IdType id = getId(pojo);

        if(id ==null)
        {
            log.info("新增数据");
        }
        else {
            log.info("更新缓存数据：" + getId(pojo));
        }

        if(synDB) {
//            log.info("更新数据库数据：" + getId(pojo));
            updateDB(pojo);
            try {
                pojo = get(getQueryParam(pojo));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String rkey = getKey(getQueryParam(pojo));
        util.set(rkey,pojo);
        return pojo;
    }

    /**
     * 加锁操作
     * @param pojo
     * @param function
     * @param <R>
     * @return
     * @throws Exception
     */
    public <R> R operByLock(POJO pojo, boolean synDB,BiFunction<POJO,Boolean,R> function) throws Exception {
        try {
            lock(pojo);
            return function.apply(pojo,synDB);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw e;
        }
        finally {
            unlock(pojo);
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /////////////////////////////////////////缓存加锁//////////////////////////////////////////////////////////////


    public void lock(POJO pojo) throws Exception {
        if(getQueryParam(pojo)==null)
        {
            log.info("{}对象的检索对象为空，不支持加锁！！",pojo);
            return;
        }

        String keyLock = getKey(getQueryParam(pojo)) +".LOCK";
        util.lock(keyLock);
    }

    public boolean lock(POJO pojo,long timeout) throws Exception {
        if(getQueryParam(pojo)==null)
        {
            log.info("{}对象的检索对象为空，不支持加锁！！",pojo);
            return false;
        }
        String keyLock = getKey(getQueryParam(pojo))  +".LOCK";
        return util.lock(keyLock,timeout);
    }

    public void unlock(POJO pojo) throws Exception {
        if(getQueryParam(pojo)==null)
        {
            log.info("{}对象的检索对象为空，不支持加锁！！",pojo);
            return;
        }
        String keyLock = getKey(getQueryParam(pojo))  +".LOCK";
        util.unlock(keyLock);
    }

//    public void lock(String key) throws Exception {
//        String keyLock = key +".LOCK";
//        util.lock(keyLock);
//    }
//
//    public boolean lock(String key,long timeout) throws Exception {
//        String keyLock = key +".LOCK";
//        return util.lock(keyLock,timeout);
//    }
//
//    public void unlock(String key) throws Exception {
//        String keyLock = key +".LOCK";
//        util.unlock(keyLock);
//    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////辅助方法///////////////////////////////////////////////////////////
    /**
     * 获取单个缓存数据
     * @param param
     * @return
     * @throws Exception
     */
    public String getKey(QueryParam param) {
        String key = util.createCacheKey(cachePre,pojo_sign,cacheLast,String.valueOf(param));
        return key;
    }

}
