package com.mg.node.common.service.lock;

import com.mg.node.common.constant.PoolConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMultiLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.recipes.locks.InterProcessReadWriteLock;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreMutex;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class MgCloudLockFactory {


    @Autowired
    CuratorFramework framework;


    //存储已使用锁
    ThreadLocal<LockStore> threadLocal = new ThreadLocal<>();


    /**
     * 获取互斥锁
     * @param name
     * @return
     * @throws Exception
     */
    public LockItem getLock(String name) {
        if(threadLocal.get()==null)
        {
            threadLocal.set(new LockStore());
        }
        LockStore lockStore = threadLocal.get();
        return threadLocal.get().getLock(framework,buildPath(name));
    }


    public void acquire(String name) throws Exception {
        LockItem item = getLock(name);
        item.mutex.acquire();
        item.acquires++;
    }


    public boolean acquire(String name,long time) throws Exception {
        LockItem item = getLock(name);
        boolean status = item.mutex.acquire(time, TimeUnit.MICROSECONDS);
        if(status){
            item.acquires++;
        }
        return status;
    }

    public void release(String name) throws Exception {
        LockItem item = getLock(name);
        item.acquires--;
        item.mutex.release();
        if(item.acquires==0) {
            threadLocal.get().removeLock(buildPath(name));
        }
    }



    /**
     * 获取互斥锁
     * @param name
     * @return
     * @throws Exception
     */
    public InterProcessMutex getMutexLock(String name) throws Exception {
        return new InterProcessMutex(framework,buildPath(name));
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
        for(String str : PoolConstant.LOCK_ROOT)
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
        CuratorFramework framework= CuratorFrameworkFactory.newClient(
        "10.0.127.103:2181",
        5000,
        5000,
        new RetryNTimes(3, 1000));

        framework.start();

        InterProcessMutex mutex1 =  new InterProcessMutex(framework,"/lock/matao");
        mutex1.acquire();
        Thread.sleep(1000*5);
        mutex1.release();


        InterProcessMutex mutex2 =  new InterProcessMutex(framework,"/lock/matao");
        mutex2.acquire();
        mutex2.release();

    }

    private class LockStore{

        private ConcurrentHashMap<String,LockItem> store = new ConcurrentHashMap();

        public LockItem getLock(CuratorFramework framework, String path)
        {
            LockItem item = store.get(path);
            if(item==null)
            {
                item =  new LockItem(new InterProcessMutex(framework,path));
                store.put(path,item);
            }
            return item;
        }

        public void removeLock(String path)
        {
            store.remove(path);
        }

    }

    private class LockItem{

        public LockItem(InterProcessMutex mutex)
        {
            this.mutex = mutex;
        }

        InterProcessMutex mutex;
        int acquires =0;
    }

}
