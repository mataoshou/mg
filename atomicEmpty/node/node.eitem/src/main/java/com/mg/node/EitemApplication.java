package com.mg.node;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EitemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EitemApplication.class, args);
    }

}




