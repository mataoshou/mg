package com.mg.empty.demo.thread.create;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class MgDemo202063003 implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000*5);
        return Thread.currentThread().getName() +" task finish";
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MgDemo202063003 demo = new MgDemo202063003();
        FutureTask<String> future = new FutureTask<String>(demo);
        Thread thread = new Thread(future);
        thread.setName("mgTask1");
        thread.start();

        log.info(future.isDone()+"");
        log.info(future.get());
        log.info(future.isDone()+"");
    }
}
