package com.mg.empty.demo.mg20200603;

import lombok.SneakyThrows;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ZKDemo implements Watcher {

    private static ZooKeeper zk = null;
    private static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        String path = "/mg/zkdemo";
        //连接zookeeper并且注册一个默认的监听器
        zk = new ZooKeeper("10.0.127.235:2181", 5000, //
                new ZKDemo());
        latch.await();

//        Thread.sleep(1000*10);
        if(null!=zk.exists(path,false)) {
            zk.delete(path, -1);
            zk.delete("/mg", -1);
        }
        zk.create("/mg","MG驿站".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        String result= zk.create(path,"mg".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//        result=zk.create(path,"demo".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);

        System.out.println("..............." + result);

        zk.getData(path,true,stat);
        Thread.sleep(1000*10);
        zk.setData(path, ("mg"+System.currentTimeMillis()).getBytes(),-1);
        Thread.sleep(1000*10);
        zk.setData(path, ("mg"+System.currentTimeMillis()).getBytes(),-1);
        Thread.sleep(1000*60);

    }
    private static Stat stat = new Stat();
    @SneakyThrows
    @Override
    public void process(WatchedEvent watchedEvent) {
        if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {  //zk连接成功通知事件

            if(watchedEvent.getType() == Event.EventType.None)
            {
                latch.countDown();
            }
            else{
                System.out.println("11111....."+watchedEvent.getType());
                System.out.println("22222....."+this);
                System.out.println("....."+watchedEvent.getPath()+"......"+new String(zk.getData(watchedEvent.getPath(),true,stat)));
            }
        }
    }
}
