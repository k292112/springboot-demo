package com.demo.zookeeper;

import org.apache.zookeeper.*;

import java.util.concurrent.CountDownLatch;

public class Test {
    public static void main(String[] args) {
        ZooKeeper zooKeeper = null;
        try {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            //连接成功后，会回调watcher监听，此连接操作是异步的，执行完new语句后，直接调用后续代码
            //  可指定多台服务地址 127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183
            zooKeeper = new ZooKeeper("127.0.0.1:2181", 4000, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    if (Event.KeeperState.SyncConnected == event.getState()) {
                    }
                    //如果收到了服务端的响应事件,连接成功
                    countDownLatch.countDown();
                    System.out.println(("####watch path:" + event.getPath()));
                    System.out.println(("####watch State:" + event.getState()));
                    System.out.println(("####watch Type:" + event.getType()));
                }
            });
            countDownLatch.await();
            System.out.println(("【初始化ZooKeeper连接状态....】={}" + zooKeeper.getState()));

            // 创建根目录节点
            // 路径为/tmp_root_path
            // 节点内容为字符串"我是根目录/tmp_root_path"
            // 创建模式为CreateMode.PERSISTENT
            System.out.println("开始创建根目录节点/tmp_root_path...");
            zooKeeper.create("/tmp_root_path", "我是根目录/tmp_root_path".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println("根目录节点/tmp_root_path创建成功！");

            Thread.sleep(1000l);

            System.out.println("...");
            System.out.println("...");
            System.out.println("...");

            // 创建第一个子目录节点
            // 路径为/tmp_root_path/childPath1
            // 节点内容为字符串"我是第一个子目录/tmp_root_path/childPath1"
            // 创建模式为CreateMode.PERSISTENT
            System.out.println("开始创建第一个子目录节点/tmp_root_path/childPath1...");
            zooKeeper.create("/tmp_root_path/childPath1",
                    "我是第一个子目录/tmp_root_path/childPath1".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println("第一个子目录节点/tmp_root_path/childPath1创建成功！");

            System.out.println("...");
            System.out.println("...");
            System.out.println("...");

            // 修改第一个子目录节点/tmp_root_path/childPath1数据
            System.out.println("开始修改第一个子目录节点/tmp_root_path/childPath1数据...");
            zooKeeper.setData("/tmp_root_path/childPath1",
                    "我是修改数据后的第一个子目录/tmp_root_path/childPath1".getBytes(), -1);
            System.out.println("修改第一个子目录节点/tmp_root_path/childPath1数据成功！");


            System.out.println("...");
            System.out.println("...");
            System.out.println("...");

            // 删除第一个子目录节点
            System.out.println("开始删除第一个子目录节点/tmp_root_path/childPath1...");
            zooKeeper.delete("/tmp_root_path/childPath1", -1);
            System.out.println("第一个子目录节点/tmp_root_path/childPath1删除成功！");


            System.out.println("...");
            System.out.println("...");
            System.out.println("...");

            // 删除根目录节点
            System.out.println("开始删除根目录节点/tmp_root_path...");
            zooKeeper.delete("/tmp_root_path", -1);
            System.out.println("根目录节点/tmp_root_path删除成功！");

        } catch (Exception e) {
            System.out.println(("初始化ZooKeeper连接异常....】={}" + e));
        } finally {
            if (zooKeeper != null) {
                try {
                    zooKeeper.close();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
