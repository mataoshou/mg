package com.mg.compose.common.service.task;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.zookeeper.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class MgCloudLock {


    @Autowired
    CuratorFramework framework;

    public void getLock(String[] path) throws Exception {
//        framework.start();
        //4 分布式锁
        InterProcessMutex lock = new InterProcessMutex(framework, "/mg/chrldren");//用于锁的节点
        lock.acquire();
    }

    public void unLock()
    {

    }

    public boolean tryLock()
    {
        return false;
    }

    public boolean tryLock(long time)
    {
        return false;
    }

    public static void main(String[] args) throws InterruptedException, IOException, KeeperException {
//        MgCloudLock lock = new MgCloudLock();
//        lock.lock();
    }

}
