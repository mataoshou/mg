package com.mg.node.common.service.cache;

import com.alibaba.fastjson.JSON;
import com.mg.common.pojo.ResultItem;
import com.mg.node.common.constant.CacheConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.bcel.generic.POP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

import java.util.ArrayList;
import java.util.List;


/**
 * 缓存的基础类
 * 待改进部分  缓存的删除和编辑
 * @param <PoPOJO>
 */
@Slf4j
public abstract class IBaseCache<PoPOJO,IdType>{


    @Autowired
    CacheUtil util;

    ///////////////////////////////////////////////////常量区////////////////////////////////////////////////////////
    String cachePre ="";
    String cacheLast ="";

    private long liveTime = CacheConstant.CACHE_LIVE;

    public void setLiveTime(long live)
    {
        liveTime = live;
    }

    String list_sign = CacheConstant.CACHE_DATE_LIST_SIGN;

    String pojo_sign = CacheConstant.CACHE_DATE_POJO_SIGN;

    public void setList_sign(String list_sign) {
        this.list_sign = list_sign;
    }

    public void setPojo_sign(String pojo_sign) {
        this.pojo_sign = pojo_sign;
    }


    private Class<PoPOJO> pojoCl;

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
    protected abstract PoPOJO getPojo(IdType id);

    /**
     * 缓存中没有数据，从数据库中获取 单个数据
     * @return
     */
    protected abstract PoPOJO updatePojo(PoPOJO pojo);

    /**
     * 缓存中没有数据，从数据库中获取 单个数据
     * @return
     */
    protected abstract PoPOJO deletePojo(IdType id);

    public abstract IdType getId(PoPOJO pojo);

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

   //////////////////////////////////////////初始化区域/////////////////////////////////////////////////////////////


    /**
     * 设置修饰词
     */
    protected void setCacheDecorate(String _cachePre,String _cacheLast,Class<PoPOJO> pojoClass)
    {
        this.cachePre =_cachePre;
        this.cacheLast = _cacheLast;
        this.pojoCl = pojoClass;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /////////////////////////////////////////操作区域//////////////////////////////////////////////////////////////


    /**
     *获取缓存数据
     * 私有方法，不对外开放
     */
    public PoPOJO get(IdType key) throws Exception {
        String item = getKey(key);

        PoPOJO pojo = util.get(item,pojoCl);
        if(pojo==null)
        {
            pojo = getPojo(key);

        }
        return pojo;
    }


    /**
     * 获取缓存列表数据
     * @param ukeys
     * @return
     * @throws Exception
     */
    public final List<PoPOJO> getListCache(List<IdType> ukeys) throws Exception {

        List<PoPOJO> list = new ArrayList();
        for(IdType ukey:ukeys)
        {
            list.add(get(ukey));
        }
        return list;
    }


        /**
     * 删除单个pojo的缓存
     */
    private void delete(IdType key,boolean synDB) throws Exception {
        deleteListKeys();
        String rkey = getKey(key);
        util.delete(rkey);
        if(synDB)
        {
            delete(key);
        }
    }

    /**
     * 删除单个pojo的缓存
     */
    public final void delete(IdType key) throws Exception {
        delete(key,true);
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
    public final PoPOJO update(PoPOJO pojo) throws Exception {
        delete(getId(pojo));
        return setCache(getId(pojo),pojo);
    }




    /**
     *缓存单个pojo数据
     */
    public final PoPOJO setCache(IdType key, PoPOJO pojo )throws Exception{

        String uKey = getKey(key);

        try {
            if (lock(uKey)) {
                util.delete(uKey);
                log.info("添加缓存数据：" + uKey);

                util.delete(uKey);

                util.set(uKey,pojo,liveTime);
                unlock(uKey);
                return pojo;
            }
        }
        catch (Exception e)
        {
            unlock(uKey);
            log.info("缓存数据更新失败："+uKey);
            e.printStackTrace();
            throw e;
        }

        return pojo;
    }

    public boolean lock(String key)
    {
        String keyLock = key +".LOCK";
        return util.lock(keyLock);
    }

    public boolean lock(String key,long timeout)
    {
        String keyLock = key +".LOCK";
        return util.lock(keyLock,timeout);
    }

    public boolean unlock(String key)
    {
        String keyLock = key +".LOCK";
        return util.unlock(keyLock);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////辅助方法///////////////////////////////////////////////////////////
    /**
     * 获取单个缓存数据
     * @param id
     * @return
     * @throws Exception
     */
    public String getKey(IdType id) throws Exception {
        return util.createCacheKey(cachePre,pojo_sign,cacheLast,String.valueOf(id));
    }

}
