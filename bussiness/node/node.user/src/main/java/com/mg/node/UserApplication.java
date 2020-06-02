package com.mg.node;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import com.mg.node.common.constant.DBConstant;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@MapperScan(DBConstant.DB_MERGEDAO_PACKAGE)
@EnableEurekaClient
@EnableDistributedTransaction
public class UserApplication  {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
