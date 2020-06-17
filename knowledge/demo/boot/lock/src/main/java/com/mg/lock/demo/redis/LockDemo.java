package com.mg.lock.demo.redis;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;

@Slf4j
public class LockDemo {

    public void demo(RLock lock)
    {
        for(int i=0;i<5;i++)
        {
            Thread thread = new Thread(()->{
                try {
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


    public void demo2()
    {
        RReadWriteLock rwlock = new RedisLock().getrwLock("demo");
        RLock readLock = rwlock.readLock();
        RLock writeLock = rwlock.writeLock();

        for(int i=0;i<5;i++)
        {
            Thread thread = new Thread(()->{
                try {
                    log.info(String.format("[%s]尝试获取读锁！！",Thread.currentThread().getName()));
                    readLock.lock();
                    log.info(String.format("[%s]获取读锁成功！！",Thread.currentThread().getName()));
                    Thread.sleep(1000*5);
                    readLock.unlock();
                    log.info(String.format("[%s]释放读锁！！",Thread.currentThread().getName()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            thread.setName("demoRead"+i);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread.start();
        }


        for(int i=0;i<5;i++)
        {
            Thread thread = new Thread(()->{
                try {
                    log.info(String.format("[%s]尝试获取写锁！！",Thread.currentThread().getName()));
                    writeLock.lock();
                    log.info(String.format("[%s]获取写锁成功！！",Thread.currentThread().getName()));
                    Thread.sleep(1000*5);
                    writeLock.unlock();
                    log.info(String.format("[%s]释放写锁！！",Thread.currentThread().getName()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            thread.setName("demoWrite"+i);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread.start();
        }
    }

    public static void main(String[] args) {
        LockDemo demo  = new LockDemo();
        demo.demo2();
    }

}
