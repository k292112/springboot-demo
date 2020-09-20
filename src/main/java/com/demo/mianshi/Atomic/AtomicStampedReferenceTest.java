package com.demo.mianshi.Atomic;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * AtomicStampedReference 解决 ABA的问题，
 * 应用版本号  Stamp
 */
public class AtomicStampedReferenceTest {
    public static void main(String[] args) {
        java.util.concurrent.atomic.AtomicStampedReference atomicStampedReference= new java.util.concurrent.atomic.AtomicStampedReference(100,1);

        new Thread(()->{
            try {
                atomicStampedReference.compareAndSet(100,101,atomicStampedReference.getStamp()
                ,atomicStampedReference.getStamp()+1);
                System.out.println(Thread.currentThread().getName()+",stamp:"+atomicStampedReference.getStamp()+",val:"+
                        atomicStampedReference.getReference());
                atomicStampedReference.compareAndSet(101,100,atomicStampedReference.getStamp()
                        ,atomicStampedReference.getStamp()+1);
                System.out.println(Thread.currentThread().getName()+",stamp:"+atomicStampedReference.getStamp()+",val:"+
                        atomicStampedReference.getReference());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

        new Thread(()->{
            try {
                Thread.sleep(3000);
                atomicStampedReference.compareAndSet(100,2020,atomicStampedReference.getStamp()
                        ,atomicStampedReference.getStamp()+1);

                System.out.println(Thread.currentThread().getName()+",stamp:"+atomicStampedReference.getStamp()+",val:"+
                        atomicStampedReference.getReference());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
    }
}

class User{
    String name;
    int age;
}
