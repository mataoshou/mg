package com.mg.empty.demo.jvm.hotspot;

import lombok.extern.slf4j.Slf4j;

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.ThreadMXBean;
import java.util.List;

@Slf4j
public class Service {

    public static void main(String[] args) {
        List<MemoryPoolMXBean> beans = ManagementFactory.getMemoryPoolMXBeans();

        ManagementFactory.getMemoryManagerMXBeans();

        log.info(ManagementFactory.getRuntimeMXBean().getVmName());//.getBootClassPath());

//        log.info(bean.getLoadedClassCount()+"");
        for(MemoryPoolMXBean bean:beans)
        {
            log.info("{}:{}",bean.getName(),bean.getUsage().getUsed());
        }

        ThreadMXBean bean = ManagementFactory.getThreadMXBean();

        long[] ids = bean.getAllThreadIds();
        for(int i=0;i<ids.length;i++)
        {
            log.info("线程名称：{}",bean.getThreadInfo(ids[i]).getThreadName());
        }
        log.info("线程数量：{}",bean.getThreadCount());

    }

}
