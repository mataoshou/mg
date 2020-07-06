package com.mg.empty.demo.thread.tool;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;

@Slf4j
public class MgDemo2020070202 {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(5);

        Runnable runnable = new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                log.info("...{}...等待进入...",Thread.currentThread().getName() );
                semaphore.acquire(1);
                log.info("...{}开始执行...",Thread.currentThread().getName() );
                Thread.sleep(1000*10);
                log.info("...{}开始释放",Thread.currentThread().getName() );
                semaphore.release(1);
            }
        };

        for(int i=0;i<20;i++)
        {
            Thread task = new Thread(runnable);
            task.setName("mgTask-"+(i+1));
            task.start();
            Thread.sleep(1000);
        }
    }
}
