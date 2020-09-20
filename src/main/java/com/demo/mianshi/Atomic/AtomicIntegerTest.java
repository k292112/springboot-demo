package com.demo.mianshi.Atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS: compareAndSet 比较并交换
 */
public class AtomicIntegerTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        boolean result = atomicInteger.compareAndSet(5,2019);
        System.out.println(result+",val:"+atomicInteger.get());
        boolean result2 = atomicInteger.compareAndSet(5,2019);
        System.out.println(result2+",val2:"+atomicInteger.get());
        //线程安全 ++ 为什么不用 synchronize修饰？？？  底层用了while循环 来获取当前地址的值
        try {
            atomicInteger.getAndIncrement();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
