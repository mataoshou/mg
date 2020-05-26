package com.mg.compose.common.service.task;

import com.mg.compose.common.constant.PoolConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池 创建
 */
@Component
@Configuration
@EnableAsync
@Slf4j
public class PoolBuild {


    private final int corePoolSize =30;

    private  final  int maxPoolSize = 50;

    private int queueCapacity =200;

    private int keepAlive = 60;

    @Bean(PoolConstant.POOL_SCHEDULE)
    public Executor intervalExecutor()
    {
        log.info("init pool");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix(PoolConstant.POOL_SCHEDULE);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setKeepAliveSeconds(keepAlive);

        executor.initialize();

        return executor;
    }
}
