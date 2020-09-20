package com.demo.mianshi.Thread;

/**
 * 2个线程 循环打印 abab
 * 实现2：
 * note： 2个线程操作一个对象，主要是利用这个对象的 wait,notify,synchronize，然后 2个线程各自调用A,B
 */
public class PrintAB {
    static boolean flag = true;

    public static void main(String[] args) {
        PrintAB t = new PrintAB();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (t) {
                    while (true) {
                        if (!flag) {
                            try {
                                t.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } finally {
                            }
                        }
                        System.out.println("a");
                        flag = false;
                        t.notifyAll();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (t) {
                    while (true) {
                        if (flag) {
                            try {
                                t.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } finally {
                            }
                        }
                        System.out.println("b");
                        flag = true;
                        t.notifyAll();
                    }
                }
            }
        }).start();
    }
}
