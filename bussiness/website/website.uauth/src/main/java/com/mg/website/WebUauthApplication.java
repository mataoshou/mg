package com.mg.website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableAsync
@EnableDiscoveryClient
@EnableFeignClients
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebUauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebUauthApplication.class, args);
    }

}
