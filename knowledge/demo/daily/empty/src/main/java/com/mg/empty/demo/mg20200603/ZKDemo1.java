package com.mg.empty.demo.mg20200603;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

@Slf4j
public class ZKDemo1 implements Watcher {

    private static ZooKeeper zk = null;
    private static CountDownLatch latch = new CountDownLatch(1);
    private static Stat stat = new Stat();
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        String path = "/mg";
        //连接zookeeper并且注册一个默认的监听器
        zk = new ZooKeeper("192.168.200.130:2181", 5000, //
                new ZKDemo1());
        latch.await();
        log.info("......成功连接");
    }

    @SneakyThrows
    @Override
    public void process(WatchedEvent watchedEvent) {
        if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {

            if(watchedEvent.getType() == Event.EventType.None)
            {
                latch.countDown();
            }
        }
    }
}
