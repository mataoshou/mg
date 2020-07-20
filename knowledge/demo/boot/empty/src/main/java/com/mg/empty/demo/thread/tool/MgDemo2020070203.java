package com.mg.empty.demo.thread.tool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@Slf4j
public class MgDemo2020070203 {
    CyclicBarrier barrier = new CyclicBarrier(5,()->{

        log.info("{}[begin]",Thread.currentThread().getName());
        try {
            Thread.sleep(1000*3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("{}[finish]",Thread.currentThread().getName());
    });

    public void startService() throws InterruptedException {
        for(int i=0;i<5;i++) {
            Thread task = new Thread(() -> {
                try {
                    Thread.sleep(1000*1);
                    log.info("{}[wait]", Thread.currentThread().getName());
                    barrier.await();
                    log.info("{}[run]", Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
            task.start();
            Thread.sleep(1000*1);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        MgDemo2020070203 demo = new MgDemo2020070203();
        demo.startService();
    }
}
