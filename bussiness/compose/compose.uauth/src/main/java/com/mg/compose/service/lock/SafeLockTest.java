package com.mg.compose.service.lock;

import com.mg.compose.common.service.task.MgCloudLockFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.recipes.locks.InterProcessReadWriteLock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SafeLockTest {

    @Autowired
    MgCloudLockFactory lockFactory;


    @Test
    public void getLock() throws Exception {
        Runnable runnable = ()->{
            try {
                log.info("................线程启动成功"+ Thread.currentThread().getName());
                InterProcessMutex mlock = lockFactory.getLock("task");
                mlock.acquire();
                log.info(".................获取锁成功" + Thread.currentThread().getName());

                Thread.sleep(1000*14);
//
                mlock.release();
                log.info("..................释放锁成功" + Thread.currentThread().getName());

                InterProcessReadWriteLock readWriteLock = lockFactory.getReadWriteLock("tt");
            } catch (Exception e) {
                e.printStackTrace();
            }

        };
//
        Thread task1 = new Thread(runnable);
//        Thread task2 = new Thread(runnable);
        task1.start();

        Thread.sleep(1000*10);
        InterProcessMutex mlock = lockFactory.getLock("task");
        log.info(".................开始获取锁" + Thread.currentThread().getName());
//        lock.getLock("matao");
        mlock.acquire();
        log.info(".................获取锁成功" + Thread.currentThread().getName());
        mlock.release();
        log.info("..................释放锁成功" + Thread.currentThread().getName());
//        task2.start();
    }
}