package com.demo.mianshi.Thread;

/**
 * note： work类里面 实现互斥的 2个打印方法 A B。 2个线程各自调用A,B
 */
public class Work{
    volatile  boolean flag = true;

    public synchronized void printA() {
        System.out.println("AAAA");
        while (true) {
            if (!flag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("a");
            flag = false;
            this.notifyAll();
        }
    }

    public synchronized void printB() {
        System.out.println("bbbb");
        while (true) {
            if (flag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("b");
            flag = true;
            this.notifyAll();
        }
    }

    public void printC() {
        System.out.println("c");
    }

    public synchronized void printD() {
        System.out.println("d");
    }
}
