package com.mg.node.service.task;

import com.mg.node.common.constant.PoolConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@EnableScheduling
@Component
@Configuration
public class MgTask {

    @Bean
    public Item getItem()
    {
        return new Item();
    }

    @Scheduled(initialDelay=1000, fixedRate=5000)
    @Async(PoolConstant.POOL_SCHEDULE)
    public void dailyDemo() throws Exception {
        Item item = getItem();

        log.info("ssssssss..............{}" ,item );
    }

}
