package com.demo.mianshi.Atomic;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ArrayList 线程不安全： 报错java.util.ConcurrentModificationException
 * 1. vector
 * 2.Collections.synchronizedList(new ArrayList<>())
 * 3.CopyOnWriteArrayList
 */
public class MyArrayList {
    public static void main(String[] args) {
        List list = new CopyOnWriteArrayList(); // Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i <30 ; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
