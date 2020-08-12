package com.mg.empty.demo.spring.start;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

@Slf4j
public class StartRun {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println("11111111111111111111");
        stopWatch.stop();

        log.info("{}",stopWatch.getTotalTimeMillis());
    }


}
