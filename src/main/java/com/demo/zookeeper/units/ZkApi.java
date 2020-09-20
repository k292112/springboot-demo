package com.demo.zookeeper.units;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public class ZkApi {
    private static final Logger logger = LoggerFactory.getLogger(ZkApi.class);
    //@Autowired
    private ZooKeeper zkClient;

    public Stat exists(String path, boolean watch) {//判断节点释放存在
        try {
            Stat stat = zkClient.exists(path, watch);
            return stat;
        } catch (Exception e) {
            logger.error("【断指定节点是否存在异常】{},{}", path, e);
            return null;
        }
    }

    public String createNode(String path, byte[] data) {//创建 持久节点
        try {

            String s = zkClient.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            return s;
        } catch (Exception e) {
            logger.error("【创建节点是否存在异常】{},{}", path, e);
            return null;
        }

    }
    public String  getNode(String path) {//获取节点数据
        try {
            Stat stat = new Stat();

            byte[] data = zkClient.getData(path, new Watcher() {
                @Override
                public void process(WatchedEvent event) {

                }
            }, stat);
            return new String(data);

        } catch (Exception e) {
            logger.error("【获取节点是否存在异常】{}", path, e);
            return null;
        }
    }
    public Stat  setNode(String path,String data) {//设置节点数据
        try {

            return zkClient.setData(path,data.getBytes(),-1);//如果客户端传入的版本参数是"-1"，就是告诉zookeeper服务器，客户端需要基于数据的最新版本进行更新操作。
        } catch (Exception e) {
            logger.error("【设置节点是否存在异常】{}", path, e);
            return null;
        }
    }
    public List<String> getChildren(String path,Boolean watch){//获取某个节点的子节点
        try {
            List<String> children = zkClient.getChildren(path, watch);
            return children;
        } catch (Exception e) {
            logger.error("【获取节点的子节点是否存在异常】{},{}", path, e);
            return null;
        }
    }

}
