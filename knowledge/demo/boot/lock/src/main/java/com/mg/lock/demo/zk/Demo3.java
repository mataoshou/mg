package com.mg.lock.demo.zk;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.recipes.locks.InterProcessReadWriteLock;

@Slf4j
public class Demo3 {


    public void buildReadTask(InterProcessMutex lock,String pre)
    {
        for(int i=0;i<5;i++)
        {
            Thread task = new Thread(()->{

                try {
                    log.info("[{}]开始获取读锁",Thread.currentThread().getName());
                    lock.acquire();
                    log.info("[{}]获取读锁成功",Thread.currentThread().getName());
                    Thread.sleep(1000*5);
                    lock.release();
                    log.info("[{}]释放读锁",Thread.currentThread().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });
            task.setName(pre+"-mg-read-"+i);
            task.start();
        }
    }

    public void buildWriteTask(InterProcessMutex lock,String pre)
    {
        Thread task = new Thread(()->{

            try {
                log.info("[{}]开始获取写锁",Thread.currentThread().getName());
                lock.acquire();
                log.info("[{}]获取写锁成功",Thread.currentThread().getName());
                Thread.sleep(1000*5);
                lock.release();
                log.info("[{}]释放写锁",Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        task.setName(pre+"-mg-wirte");
        task.start();
    }

    public static void main(String[] args) throws Exception {
        ZkLock zkLock = new ZkLock();
        InterProcessReadWriteLock lock = zkLock.getReadWriteLock("demo");

        Demo3 demo3 = new Demo3();
        demo3.buildWriteTask(lock.writeLock(),"before");
        Thread.sleep(1000*2);
        demo3.buildReadTask(lock.readLock(),"before");
        Thread.sleep(1000*5);
        demo3.buildWriteTask(lock.writeLock(),"after");
//        Thread.sleep(1000*15);
//        demo3.buildReadTask(lock.readLock(),"after");
    }
}
