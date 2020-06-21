package com.mg.lock.demo.zk;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreMutex;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Demo2 {

    public void lock1(InterProcessSemaphoreMutex lock) throws Exception {
        lock.acquire();
        log.info("lock1成功获取锁");
        lock2(lock);
        lock.release();
        log.info("lock1成功释放锁");
    }

    public void lock2(InterProcessSemaphoreMutex lock) throws Exception {
        log.info("lock2尝试获取锁");
        boolean result = lock.acquire(1000*10, TimeUnit.MILLISECONDS);

        if(result)
        {
            log.info("lock2成功获取锁");
            Thread.sleep(1000*10);
            lock.release();
            log.info("lock2成功释放锁");
        }
        else {
            log.info("lock2获取锁失败");
        }



    }

    public static void main(String[] args) throws Exception {
        ZkLock zkLock = new ZkLock();
        InterProcessSemaphoreMutex lock = zkLock.getSemaphoreLock("demo");
        Demo2 demo2 = new Demo2();
        demo2.lock1(lock);

    }
}
