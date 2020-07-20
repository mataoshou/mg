package com.mg.empty.demo.thread.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

@Slf4j
public class LockSupportDemo {

    public static void main(String[] args) throws InterruptedException {

        log.info("[begin]");

        Thread task = new Thread(()->{
            try {
                log.info("[block]");
                Thread.sleep(1000*3);
                LockSupport.park();
                log.info("[ready]");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        task.start();

        Thread.sleep(1000*10);
        log.info("[wait]");
        LockSupport.unpark(task);
        log.info("[finish]");


    }


}
