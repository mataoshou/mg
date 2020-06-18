package com.mg.lock.demo.zk;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMultiLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.recipes.locks.InterProcessReadWriteLock;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreMutex;
import org.apache.curator.retry.RetryNTimes;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ZkLock {
    static CuratorFramework framework= null;
    static {
        framework = CuratorFrameworkFactory.newClient(
                "106.55.154.105:2181",
                20000,
                20000,
                new RetryNTimes(3, 5000));
        framework.start();
    }


    /**
     * 获取互斥锁
     * @param name
     * @return
     * @throws Exception
     */
    public InterProcessMutex getLock(String name) throws Exception {
        return  new InterProcessMutex(framework,buildPath(name));
    }

    /**
     * 获取互斥锁
     * @param name
     * @return
     * @throws Exception
     */
    public InterProcessMutex getMutexLock(String name) throws Exception {
        return  new InterProcessMutex(framework,buildPath(name));
    }

    /**
     * 获取读写锁
     * @param name
     * @return
     * @throws Exception
     */
    public InterProcessReadWriteLock getReadWriteLock(String name) throws Exception {
        return new InterProcessReadWriteLock(framework,buildPath(name));
    }

    /**
     * 获取不可重入互斥锁
     * @param name
     * @return
     * @throws Exception
     */
    public InterProcessSemaphoreMutex getSemaphoreLock(String name) throws Exception {
        return new InterProcessSemaphoreMutex(framework,buildPath(name));
    }

    /**
     * 获取多锁  集合锁
     * @param names
     * @return
     * @throws Exception
     */
    public InterProcessMultiLock getMutilLock(List<String> names) throws Exception {
        return  new InterProcessMultiLock(framework,mutilPath(names));
    }

    public List<String> mutilPath(List<String> names){
        List<String> paths = new ArrayList<>();
        for(String name :names)
        {
            paths.add(buildPath(name));
        }
        return paths;
    }


    public String buildPath(String name)
    {
        String path = "";
        String[] roots = new String[]{"mg","mylock"};
        for(String str : roots)
        {
            if(str.startsWith("/")){
                path +="/";
            }
            path +="/" +str;
        }
        path +="/" +name;
        return path;
    }

    public static void main(String[] args) throws Exception {
        ZkLock lock = new ZkLock();
        InterProcessMutex mutex = lock.getLock("demo");

        for(int i=0;i<3;i++)
        {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        mutex.acquire();
                        log.info(String.format("[%s]抢到锁[demo]",Thread.currentThread().getName()));
                        Thread.sleep(1000*3);
                        mutex.release();
                        log.info(String.format("[%s]释放锁[demo]",Thread.currentThread().getName()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            thread.setName("mg-task-"+i);
            thread.start();
        }
    }
}
