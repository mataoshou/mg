package com.mg.empty.demo.thread.create;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MgDemo202063001 implements Runnable {
    @Override
    public void run() {
      log.info("运行线程1");
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MgDemo202063001());
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("运行线程2");
            }
        });
        thread2.start();

        Thread thread3 = new Thread(()-> {
            log.info("运行线程3");
        });
        thread3.start();
    }
}
