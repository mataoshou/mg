package com.mg.node;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import com.mg.node.common.constant.DBConstant;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScannerRegistrar;
import org.mybatis.spring.mapper.ClassPathMapperScanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableEurekaClient
//@EnableDistributedTransaction
public class MgMybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(MgMybatisApplication.class, args);
    }
}
