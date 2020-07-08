package com.mg.empty.demo.jvm.createCl;


import com.mg.empty.demo.DemoApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = DemoApplication.class)
class ThBeanFactoryTest {

    @Autowired
    @Qualifier("mgDemoImp")
    IDemo demo1;

    @Autowired
    @Qualifier("mgDemoImp2")
    IDemo demo2;

    @Test
    void testAdd() {
        demo1.sayHello();
        demo2.sayHello();
    }
}