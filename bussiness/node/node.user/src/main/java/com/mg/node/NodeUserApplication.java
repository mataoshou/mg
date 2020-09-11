package com.mg.node;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@MapperScan(DBConstant.DB_MERGEDAO_PACKAGE)
//@EnableEurekaClient
public class NodeUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(NodeUserApplication.class, args);
    }

}
