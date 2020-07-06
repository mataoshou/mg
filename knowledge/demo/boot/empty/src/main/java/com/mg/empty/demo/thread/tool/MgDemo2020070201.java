package com.mg.empty.demo.thread.tool;

import javafx.concurrent.Task;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
public class MgDemo2020070201 {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);

        Runnable task = new Runnable() {
            @Override
            public void run() {
                log.info(Thread.currentThread().getName() +"任务执行..");
                latch.countDown();
            }
        };
        for(int i=0;i<5;i++)
        {
            Thread thread = new Thread(task);
            thread.start();
        }
        log.info("mg wait!!");
        latch.await();
        log.info("mg finish!!");
    }
}
