package com.mg.compose.service.task;

import com.mg.compose.common.constant.PoolConstant;
import com.mg.compose.common.service.task.MgCloudLockFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@EnableScheduling
@Component
public class UserTask {

    @Autowired
    MgCloudLockFactory factory;

//    @Scheduled(initialDelay=1000, fixedRate=5000)
//    @Async(PoolConstant.POOL_SCHEDULE)
//    public void dailyDemo() throws Exception {
//        log.info("获取锁地址");
//        InterProcessMutex lock = factory.getLock("user");
//
//        lock.acquire();
//        log.info("获取成功");
//    }

}
