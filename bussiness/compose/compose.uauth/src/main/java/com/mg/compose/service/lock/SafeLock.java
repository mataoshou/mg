package com.mg.compose.service.lock;

import com.mg.compose.common.service.task.MgCloudLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SafeLock {

    @Autowired
    MgCloudLock lock;

    public void getLock() throws Exception {
        lock.getLock(new String[]{"mg"});
    }
}
