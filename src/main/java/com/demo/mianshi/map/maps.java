package com.demo.mianshi.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * map 接口相关操作
 */
public class maps {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        //hashMapTest();// 无序 线程不安全
        //treeMapTest();// 无序 线程不安全
        //LinkedHashMapTest();// 有序 线程不安全
        concurrentHashMapTest();// 无序 线程安全

        System.out.println((System.currentTimeMillis() - start) + " ms");
    }

    public static void hashMapTest() {
        Map hashMap = new HashMap();
        for (int i = 0; i < 5000; i++) {
            hashMap.put("hashMap_" + i, "hashMapVal" + i);
        }
        hashMap.forEach((key, value) -> {
            System.out.println("key:" + key + ",value:" + value);
        });
    }

    public static void treeMapTest() {
        Map treeMap = new TreeMap();
        for (int i = 0; i < 5000; i++) {
            treeMap.put("treeMap_" + i, "treeMapVal" + i);
        }
        treeMap.forEach((key, value) -> {
            System.out.println("key:" + key + ",value:" + value);
        });
    }

    public static void LinkedHashMapTest() {
        Map linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < 5000; i++) {
            linkedHashMap.put("linkedHashMap_" + i, "linkedHashMap" + i);
        }
        linkedHashMap.forEach((key, value) -> {
            System.out.println("key:" + key + ",value:" + value);
        });
    }

    public static void concurrentHashMapTest() {
        Map concurrentHashMap = new ConcurrentHashMap();
        for (int i = 0; i < 5000; i++) {
            concurrentHashMap.put("concurrentHashMap_" + i, "concurrentHashMap" + i);
        }
        concurrentHashMap.forEach((key, value) -> {
            System.out.println("key:" + key + ",value:" + value);
        });
    }
}
