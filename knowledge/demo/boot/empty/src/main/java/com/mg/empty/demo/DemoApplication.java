package com.mg.empty.demo;

import com.mg.empty.demo.jvm.createCl.IDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

//    @Autowired
//    IDemo demo;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
