package com.demo;

import com.alibaba.fastjson.JSONObject;
import com.demo.web.service.UserService;
import com.demo.zookeeper.units.ZkApi;
import org.apache.zookeeper.data.Stat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {
    //    @Autowired
//    private ZooKeeper zkApi;
    //@Autowired
    private ZkApi zkApi;
    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {//判断节点释放存在
        Stat myzookeeper = zkApi.exists("/myzookeeper", true);
        System.out.println(myzookeeper);
    }
    @Test
    void createNode() {//创建 持久节点
        String s = zkApi.createNode("/persistentNode", "persistentData".getBytes());
        System.out.println(s);
    }
    @Test
    void getNode() {//获取节点数据
        Stat stat = new Stat();
        String data = zkApi.getNode("/persistentNode");
        System.out.println(data);
    }
    @Test
    void setNode() {//获取节点数据
        Stat stat =zkApi.setNode("/persistentNode","bcd");
        System.out.println(stat);
    }

    @Test
    void getChildren() {//获取某个节点的子接口
        List<String> children = zkApi.getChildren("/", false);
        System.out.println(children);
    }
    @Test
    public void insertUser(){
        Map user = new HashMap();
        user.put("username","yang");
        user.put("password","yang");
        user.put("nickname","yang");
        JSONObject jsonObject = new JSONObject(user);
        //#{username}, #{password}, #{nickname}, #{roleId}
        userService.addUser(jsonObject);
    }
}