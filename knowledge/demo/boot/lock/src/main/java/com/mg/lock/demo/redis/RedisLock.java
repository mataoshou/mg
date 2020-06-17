package com.mg.lock.demo.redis;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import sun.rmi.runtime.Log;

@Slf4j
public class RedisLock {

    static Config config =null;
    static RedissonClient redisson =null;
    static {
        config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        redisson = Redisson.create(config);
    }

    public RLock getLock(String lockName)
    {
        RLock lock =redisson.getLock(lockName);
        return lock;
    }

    public RLock getFairLock(String lockName)
    {
        RLock lock =redisson.getFairLock(lockName);
        redisson.getReadWriteLock(lockName);
        return lock;
    }
    public RReadWriteLock getrwLock(String lockName)
    {
        RReadWriteLock lock = redisson.getReadWriteLock(lockName);
        return lock;
    }

    public static void main(String[] args) {
        RLock lock = new RedisLock().getLock("demo");

        for(int i=0;i<5;i++)
        {
            Thread thread = new Thread(()->{
                try {
//                    Thread.sleep(1000*1);
                    log.info(String.format("[%s]尝试获取锁！！",Thread.currentThread().getName()));
                    lock.lock();
                    log.info(String.format("[%s]获取锁成功！！",Thread.currentThread().getName()));
                    Thread.sleep(1000*5);
                    lock.unlock();
                    log.info(String.format("[%s]释放锁！！",Thread.currentThread().getName()));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });
            thread.setName("demo"+i);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread.start();
        }
    }

}
