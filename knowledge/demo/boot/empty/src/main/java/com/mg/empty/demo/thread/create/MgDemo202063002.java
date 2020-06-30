package com.mg.empty.demo.thread.create;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MgDemo202063002 extends Thread {


    @Override
    public void run() {
        log.info("运行线程1");
    }

    public static void main(String[] args) {
        MgDemo202063002 demo = new MgDemo202063002();
        demo.start();
    }
}
