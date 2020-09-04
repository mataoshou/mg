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
public abstract class IBaseCache<PoPOJO>{


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



    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /////////////////////////////////////  自定义区域  ////////////////////////////////////////////////////////////
    /**
     * 检查是否更新缓存
     * @param key
     * @return
     */
    protected abstract boolean check(String key);



    /**
     * 更新缓存前，需要更新数据库的数据
     * @param pojo
     * @return
     */
    protected abstract ResultItem<PoPOJO> updatePojo(String pojo,PoPOJO dtoPOJO);


    /**
     * 缓存中没有数据，从数据库中获取 单个数据
     * @return
     */
    protected abstract ResultItem<PoPOJO> getPojoByDB(String id);


    /**
     * 缓存中没有数据，从数据库中获取 单个数据
     * @return
     */
    protected abstract ResultItem<PoPOJO> deletePojoByDB(String id);

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

   //////////////////////////////////////////初始化区域/////////////////////////////////////////////////////////////


    /**
     * 设置修饰词
     */
    protected void setCacheDecorate(String _cachePre,String _cacheLast)
    {
        this.cachePre =_cachePre;
        this.cacheLast = _cacheLast;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /////////////////////////////////////////操作区域//////////////////////////////////////////////////////////////


    /**
     *获取缓存数据
     * 私有方法，不对外开放
     */
    private PoPOJO get(String key,Class<PoPOJO> cl) throws Exception {
        String item = getKey(key);

        PoPOJO pojo = util.get(item,cl);
        if(pojo==null)
        {
            pojo = getPojoByDB(key).toItem();

        }
        return pojo;
    }


    /**
     * 获取缓存列表数据
     * @param ukeys
     * @return
     * @throws Exception
     */
    public final List<PoPOJO> getListCache(List<String> ukeys,Class<PoPOJO> cl) throws Exception {

        List<PoPOJO> list = new ArrayList();
        for(String ukey:ukeys)
        {
            list.add(get(ukey,cl));
        }
        return list;
    }


        /**
     * 删除单个pojo的缓存
     */
    private void delete(String key,boolean synDB) throws Exception {
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
    public final void delete(String key) throws Exception {
        delete(key,true);
    }

    /**
     * 删除所有列表数据的缓存
     * 私有方法，不对外开放
     */
    private  void deleteListKeys()
    {
        String keyPattern =  cachePre + "." + list_sign +"*";
        log.info("清理列表数据：" + keyPattern);
        util.deleteKeys(keyPattern);
    }

    /**
     * 更新缓存 删除数据,然后更新数据
     * @return
     */
    public final PoPOJO update(String key,PoPOJO pojo,boolean synDB) throws Exception {
        delete(key,false);

        return  setCache(key,pojo,true);
    }




    /**
     *缓存单个pojo数据
     */
    public final PoPOJO setCache(String key, PoPOJO pojo , boolean synDB)throws Exception{

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
     * @param guid
     * @return
     * @throws Exception
     */
    public String getKey(String guid) throws Exception {
        return util.createCacheKey(cachePre,pojo_sign,cacheLast,guid);
    }

}
