package com.demo.mianshi.Thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ThreadLocal: 线程局部变量副本，各个线程独立副本。缺点：内存泄漏，线程执行完需手动remove（）;
 */
public class ThreadLocalDemo {
    // 因为 simpleDateFormat 是成员变量，公用会报错
    //Exception in thread "Thread-0" Exception in thread "Thread-1"
    // java.lang.NumberFormatException: multiple points
    //private static   SimpleDateFormat sf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
    private static ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal = ThreadLocal.withInitial(()->
        new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"));

    public static void main(String[] args) {
        // 1。多个线程对 日期操作
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Date date = ThreadLocalDemo.parseDate("2020-09-09 12:10:10");
                    System.out.println(date);
                    simpleDateFormatThreadLocal.remove();// 内存泄漏，线程执行完需手动remove（）
                }
            }).start();
        }

    }

    public static Date parseDate(String s) {
        Date date = null;
        try {
            date = simpleDateFormatThreadLocal.get().parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
