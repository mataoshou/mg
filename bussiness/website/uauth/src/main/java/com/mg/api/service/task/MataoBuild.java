package com.mg.api.service.task;
//
//import com.shineon.coder.common.constant.PoolConstant;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.scheduling.annotation.Schedules;
//import org.springframework.stereotype.Component;
//
//import java.util.concurrent.TimeUnit;
//
//@Component
//public class MataoBuild {
//    @Async(PoolConstant.POOL_SCHEDULE)
//    public void build()
//    {
//
//        try {
//            Thread.sleep(1000*3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(Thread.currentThread().getName() + ".....................build");
//    }
//
//    int count =0;
//    @Scheduled(fixedRate = 2000)
//    @Async(PoolConstant.POOL_SCHEDULE)
//    public void intervalBuild() throws Exception {
//        count++;
////        if(count%4==0)
////        {
////            throw new Exception("i am exception");
////        }
//        System.out.println(Thread.currentThread().getName() + ".....................intervalBuild" + count);
//    }
//
//    @Scheduled(fixedRate = 1000)
//    @Async(PoolConstant.POOL_SCHEDULE)
//    public void intervalBuild1() throws Exception {
//
//        System.out.println(Thread.currentThread().getName() +".....................intervalBuild1..." );
//
//    }
//
//    @Scheduled(fixedRate = 1000)
//    @Async(PoolConstant.POOL_SCHEDULE)
//    public void intervalBuild2() throws Exception {
//
//        System.out.println(Thread.currentThread().getName() +".....................intervalBuild2..." );
//    }
//}
