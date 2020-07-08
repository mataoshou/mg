package com.mg.empty.demo.lock.support;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

@Slf4j
public class MgDemo2020070901 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            LockSupport.park();
            log.info("...continue");
        });
        thread.start();
        Thread.sleep(1000*5);
        log.info("...release");
        LockSupport.unpark(thread);
    }
}
