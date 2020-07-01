package com.mg.empty.demo.thread.pool;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Status {

    public static void main(String[] args) {
        int COUNT_BITS = Integer.SIZE - 3;
        log.info("{}",(1 << COUNT_BITS) - 1);

        int RUNNING    = -1 << COUNT_BITS;
        int CAPACITY = (1 << COUNT_BITS) - 1;
        log.info("{}",RUNNING);
        log.info("{}",1<<2);

        log.info("{}",-1 << COUNT_BITS);
        log.info("{}",0 << COUNT_BITS);
        log.info("{}",1 << COUNT_BITS);
        log.info("{}",2 << COUNT_BITS);
        log.info("{}",3 << COUNT_BITS);
    }
}
