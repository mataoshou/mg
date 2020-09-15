package com.mg.compose;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
//@EnableEurekaClient
@EnableAsync
@EnableFeignClients
@EnableDiscoveryClient
public class ComposeAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComposeAuthApplication.class, args);
    }

}
