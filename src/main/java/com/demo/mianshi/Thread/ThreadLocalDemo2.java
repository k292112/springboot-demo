package com.demo.mianshi.Thread;

import java.util.concurrent.CountDownLatch;

/**
 * ThreadLocal: 线程局部变量副本，各个线程独立副本。缺点：内存泄漏，线程执行完需手动remove（）;
 *  如果多个线程 对 一个成员变量写操作，ThreadLocal 并不能保证线程安全。
 *  只有 多个线程都使用 一个变量初始值的副本的时候，这个才有用。
 */
public class ThreadLocalDemo2 {

    int num = 10;
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal();
    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) {
        ThreadLocalDemo2 t = new ThreadLocalDemo2();
        // 多个线程对 a 加5次
        for (int i = 0; i < 2; i++) {
            int num = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //t.add();
                    threadLocal.set(t.num);
                    int count = threadLocal.get()+num;
                    System.out.println(Thread.currentThread().getName()+":"+count);
                    countDownLatch.countDown();
                }
            }).start();
        }


        try {
            countDownLatch.await();
            System.out.println(t.num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public  void add(){
        //num = num+10;
        threadLocal.set(num);
        num = threadLocal.get()+10;

    }
}
