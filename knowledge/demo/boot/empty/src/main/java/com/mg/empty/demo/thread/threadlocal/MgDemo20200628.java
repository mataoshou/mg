package com.mg.empty.demo.thread.threadlocal;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MgDemo20200628 implements Runnable {

    private static ThreadLocal<String> local=new ThreadLocal<>();
    @Override
    public void run() {
        try {
            local.set(Thread.currentThread().getName() +"---" + System.currentTimeMillis());
            Thread.sleep(1000*5);
            log.info(local.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        MgDemo20200628 demo =new MgDemo20200628();
        for(int i=0;i<3;i++)
        {
            Thread task = new Thread(demo);
            task.start();
        }
    }
}
