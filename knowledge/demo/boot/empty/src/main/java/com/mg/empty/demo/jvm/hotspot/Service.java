package com.mg.empty.demo.jvm.hotspot;

import lombok.extern.slf4j.Slf4j;

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.util.List;

@Slf4j
public class Service {

    public static void main(String[] args) {

        List<MemoryPoolMXBean> beans = ManagementFactory.getMemoryPoolMXBeans();


        log.info(ManagementFactory.getRuntimeMXBean().getVmName());//.getBootClassPath());

//        log.info(bean.getLoadedClassCount()+"");
        for(MemoryPoolMXBean bean:beans)
        {
            log.info("{}:{}",bean.getName(),bean.getUsage().getUsed());
        }
    }

}
