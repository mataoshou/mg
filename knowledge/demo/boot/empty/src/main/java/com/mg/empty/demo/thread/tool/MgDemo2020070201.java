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
                try {
                    Thread.sleep(1000*10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info(Thread.currentThread().getName() +"任务执行..");
                latch.countDown();
                log.info(Thread.currentThread().getName() +"任务结束执行..");
            }
        };
        for(int i=0;i<10;i++)
        {
            Thread thread = new Thread(task);
            thread.start();
            Thread.sleep(1000);
        }
        log.info("mg wait!!");
        latch.await();
        log.info("mg finish!!");
        latch.await();
        log.info("mg finish2!!");
    }
}
