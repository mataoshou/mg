package com.mg.node.service.task;

import com.mg.node.common.constant.PoolConstant;
import com.mg.node.db.sql.build.MgTemplate;
import lombok.extern.slf4j.Slf4j;
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
    MgTemplate template;

    @Scheduled(initialDelay=1000, fixedRate=5000)
    @Async(PoolConstant.POOL_SCHEDULE)
    public void dailyDemo() throws Exception {
        log.info("1111.......................{}",template.getById("111").getId());
        log.info("2222.......................{}",template.getBySql("select * from rmt_actior_info where id=\"111\"").getId());
    }

}
