package com.mg.empty.demo.thread.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class CondtionDemo extends  Thread {


    Condition condition ;
    ReentrantLock lock ;

    @Override
    public void run() {
        try {
            Thread.sleep(1000*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("[signal]");
        lock.lock();
        condition.signal();
        lock.unlock();
        log.info("[ready]");

    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        CondtionDemo demo = new CondtionDemo();
        demo.condition = condition;
        demo.lock = lock;
        demo.start();
        log.info("[begin]");
        lock.lock();
        log.info("[wait]");
        condition.await();
        log.info("[finish]");
    }
}
