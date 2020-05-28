package com.mg.node.common.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class CuratorConfiguration {
    @Value("${curator.retryCount}")
    private int retryCount;

    @Value("${curator.elapsedTimeMs}")
    private int elapsedTimeMs;

    @Value("${curator.connectString}")
    private String connectString;

    @Value("${curator.sessionTimeoutMs}")
    private int sessionTimeoutMs;

    @Value("${curator.connectionTimeoutMs}")
    private int connectionTimeoutMs;

    @Bean(initMethod = "start")
    public CuratorFramework curatorFramework() {
        System.out.println(".....get CuratorFramework");
//        return CuratorFrameworkFactory.newClient(
//                this.connectString,
//                this.sessionTimeoutMs,
//                this.connectionTimeoutMs,
//                new RetryNTimes(this.retryCount, this.elapsedTimeMs));


        CuratorFramework framework= CuratorFrameworkFactory.newClient(
                "10.0.127.235:2181",
                5000,
                5000,
                new RetryNTimes(3, 1000));
//        framework.start();
        return framework;
    }
}
