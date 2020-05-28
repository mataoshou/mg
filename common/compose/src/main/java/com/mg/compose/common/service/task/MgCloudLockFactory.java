package com.mg.compose.common.service.task;

import com.mg.compose.common.constant.PoolConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMultiLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.recipes.locks.InterProcessReadWriteLock;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreMutex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MgCloudLockFactory {


    @Autowired
    CuratorFramework framework;

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

}
