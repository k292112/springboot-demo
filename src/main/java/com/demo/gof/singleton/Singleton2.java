package com.demo.gof.singleton;

/**
 * 单例模式-懒汉式
 */
public class Singleton2 {
    private static volatile Singleton2 singleton2;
    private Singleton2(){}

    public static Singleton2 getInstance(){
        if(singleton2 == null){
            synchronized (Singleton2.class){
                if (singleton2 == null){
                    singleton2 = new Singleton2();
                }
            }
        }
        return  singleton2;
    }

    public static void main(String[] args) {
        Singleton2 singleton1 = Singleton2.getInstance();
        Singleton2 singleton2 = Singleton2.getInstance();
        System.out.println(singleton1==singleton2);
    }

}
