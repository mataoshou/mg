package com.mg.empty.demo.thread.pool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MgDemo2020070101 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,20,30, TimeUnit.SECONDS
        ,new ArrayBlockingQueue<>(512));


        Runnable runnable = new Runnable() {

            volatile int count;

            @Override
            public void run() {
                count++;
//                log.info(count+"");
                log.info(Thread.currentThread().getName() + "....任务"+count+"...." + System.currentTimeMillis());
            }
        };

        for(int i=0;i<100;i++) {
            executor.execute(runnable);
        }


    }
}
