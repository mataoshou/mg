package com.mg.empty.demo.thread.pool;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MgDemo2020070101 {
    @SneakyThrows
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,20,30, TimeUnit.SECONDS
        ,new ArrayBlockingQueue<>(512));


        Runnable runnable = new Runnable() {

            private ThreadLocal<Integer> value = new ThreadLocal<>();

            @Override
            public void run() {
                if(value.get()==null)
                {
                    value.set(0);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                value.set(value.get()+1);
                log.info(Thread.currentThread().getName() + "....任务"+value.get()+"...." + System.currentTimeMillis());
            }
        };

        for(int i=0;i<100;i++) {
            executor.execute(runnable);
        }

        while(true)
        {
            Thread.sleep(1000);
            log.info(executor.getTaskCount() +"...." +executor.getActiveCount()
                    +"......"+executor.getCompletedTaskCount());

        }


    }
}
