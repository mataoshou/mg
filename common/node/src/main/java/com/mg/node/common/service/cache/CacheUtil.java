package com.mg.node.common.service.cache;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mg.common.util.Md5Util;
import com.mg.node.common.constant.CacheConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * redis缓存辅助工具类
 */
@Component
@Slf4j
public class CacheUtil implements ApplicationListener<ContextRefreshedEvent>
{

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 创建 单个数据的缓存 缓存key
     * @throws Exception
     */
    public String createCacheKey(String prev, String last,String sign, String id) throws Exception {
        String cacheKey = prev + "." + sign +"." + id+"." +last;

        return cacheKey;
    }


    private JSONObject toJson(Object row)
    {
        return (JSONObject) JSONObject.toJSON(row);
    }



    /**
     * 加锁
     * @param key
     * @return
     */
    public boolean lock(String key,long timeout)
    {

        log.debug("[尝试获取redis锁]"+ key);

        Boolean isSuccess = redisTemplate.opsForValue().setIfAbsent(key,"1", timeout, TimeUnit.MILLISECONDS);

        if(isSuccess==null)return false;

        return isSuccess;
    }

    public boolean lock(String key)
    {

        log.debug("[尝试获取redis锁]"+ key);

        Boolean isSuccess = redisTemplate.opsForValue().setIfAbsent(key,"1", CacheConstant.CACHE_LOCK_LIVE, TimeUnit.MILLISECONDS);

        if(isSuccess==null)return false;

        return isSuccess;
    }


    /**
     *  解锁
     */
    public boolean unlock(String key)
    {

        return redisTemplate.delete(key);
    }

    /**
     *  解锁
     */
    public void delete(String key)
    {

        redisTemplate.delete(key);
    }

    /**
     * 设置缓存数据 没有过期时间
     * @param key
     * @param item
     */
    public void set(String key, Object item)
    {
        redisTemplate.opsForValue().set(key,toJson(item));
    }

    /**
     * 设置缓存数据  有过期时间
     * @param key
     * @param value
     * @param interval
     */
    public void set(String key,Object value,Long interval)
    {
        redisTemplate.opsForValue().set(key,value,interval,TimeUnit.MILLISECONDS);
    }



    /**
     * 延长存活时间
     * @param key
     * @param keep
     * @return
     */
    public boolean expire(String key,long keep)
    {
        return redisTemplate.expire(key,keep,TimeUnit.MILLISECONDS);
    }

    /**
     * 获取缓存数据
     * @param key
     * @return
     */
    public <T> T get(String key,Class<T> cl)
    {
        log.info(key);
        Object value = redisTemplate.opsForValue().get(key);

        if(value==null)return null;

        if(cl.equals(String.class))
        {
            return (T) value.toString();
        }

        return JSON.parseObject(value.toString(),cl);
    }


    /**
     * 获取缓存数据
     * @param key
     * @return
     */
    public <T> List<T> list(String key,Class<T> cl)
    {
        log.info(key);
        Object value = redisTemplate.opsForValue().get(key);

        if(value==null)return null;
        if(cl.equals(String.class))
        {
            return JSONArray.parseObject(value.toString(),List.class);
        }

        return JSON.parseObject(value.toString(),List.class);
    }

    /**
     * 获取符合条件的所有缓存key
     * @param pattern
     */
    public List<String> likeKey(String pattern)
    {
        Set<String> set = redisTemplate.keys(pattern);

        List keys = new ArrayList<>(set);

        return keys;
    }

    /**
     * 获取符合条件的所有缓存key
     * @param pattern
     */
    public void deleteKeys(String pattern)
    {
       redisTemplate.delete(redisTemplate.keys(pattern));
    }


    public List<String> likeValue(String pattern)
    {
        List<String> values = new ArrayList<>();

        List<String> keys = likeKey(pattern);

        values = redisTemplate.opsForValue().multiGet(keys);

        return values;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
    }
}
