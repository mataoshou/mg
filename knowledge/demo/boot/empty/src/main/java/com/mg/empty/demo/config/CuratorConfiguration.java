//package com.mg.empty.demo.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.curator.framework.CuratorFramework;
//import org.apache.curator.framework.CuratorFrameworkFactory;
//import org.apache.curator.retry.RetryNTimes;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//
//@Configuration
//@Slf4j
//public class CuratorConfiguration {
//    @Value("${curator.retryCount}")
//    private int retryCount;
//
//    @Value("${curator.elapsedTimeMs}")
//    private int elapsedTimeMs;
//
//    @Value("${curator.connectString}")
//    private String connectString;
//
//    @Value("${curator.sessionTimeoutMs}")
//    private int sessionTimeoutMs;
//
//    @Value("${curator.connectionTimeoutMs}")
//    private int connectionTimeoutMs;
//
//    @Bean(initMethod = "start")
//    public CuratorFramework curatorFramework() {
//        CuratorFramework framework= CuratorFrameworkFactory.newClient(
//                connectString,
//                sessionTimeoutMs,
//                connectionTimeoutMs,
//                new RetryNTimes(retryCount, elapsedTimeMs));
//        return framework;
//    }
//}
