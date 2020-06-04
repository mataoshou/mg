package com.mg.empty.demo.mg20200603;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

@Slf4j
public class ZKDemo2 implements Watcher{
    private static ZooKeeper zk = null;
    private static CountDownLatch latch = new CountDownLatch(1);
    private static Stat stat = new Stat();

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        String path = "/mg";
        zk = new ZooKeeper("10.0.127.235:2181", 5000, new ZKDemo());
        latch.await();
        log.info("......成功连接");

        if(null!=zk.exists(path,false)) {
            zk.delete(path, -1);
        }
        String result= zk.create(path,"mg".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zk.getData(path,true,stat);
        Thread.sleep(1000*10);
        zk.setData(path, ("mg"+System.currentTimeMillis()).getBytes(),-1);
//        Thread.sleep(1000*10);
//        zk.setData(path, ("mg"+System.currentTimeMillis()).getBytes(),-1);
//        Thread.sleep(1000*60);

    }

    @SneakyThrows
    @Override
    public void process(WatchedEvent watchedEvent) {
        if (Watcher.Event.KeeperState.SyncConnected == watchedEvent.getState()) {

            if(watchedEvent.getType() == Watcher.Event.EventType.None)
            {
                latch.countDown();
            }
            else{
                System.out.println(watchedEvent.getPath()+"......"+new String(zk.getData(watchedEvent.getPath(),true,stat)));
            }
        }
    }
}
