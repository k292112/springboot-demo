package com.demo.mianshi.Thread;

/**
 * 2个线程 循环打印 abab
 * 实现1：
 * note： 2个线程操作 Work类， work类里面 实现互斥的 2个打印方法 A B。 2个线程各自调用A,B
 */
public class ThreadA {

    public static void main(String[] args) {
        Work t = new Work();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t.printA();
                //t.printD();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t.printB();
                //t.printC();
            }
        }).start();

    }
}
