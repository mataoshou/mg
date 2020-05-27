package com.mg.compose.service.lock;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SafeLockTest {

    @Autowired
    SafeLock lock;

    @Autowired
    SafeLock lock2;

    @Test
    public void getLock() {
        try {
            lock.getLock();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            lock2.getLock();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}