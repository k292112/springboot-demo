package com.demo.mianshi.dealLock;

class DeadLockRunnable implements Runnable {

    private final String first;
    private final String second;

    public DeadLockRunnable(String first, String second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public void run() {
        synchronized (first) {
            System.out.println(Thread.currentThread().getName() + " obtain: " + first);
            try {
                Thread.sleep(100);
                synchronized (second) {
                    System.out.println(Thread.currentThread().getName() + " obtain: " + second);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class DeadLock {
    public static void main(String[] args) throws InterruptedException {
        String lockA = "lockA";
        String lockB = "LockB";

        Thread t1 = new Thread(new DeadLockRunnable(lockA, lockB));
        Thread t2 = new Thread(new DeadLockRunnable(lockB, lockA));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}

