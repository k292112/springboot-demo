package com.demo.gof.singleton;

/**
 * 单例模式的 饿汉试
 */
public class Singleton1 {
    private static final Singleton1 singleton1 = new Singleton1();
    private Singleton1(){}
    public static Singleton1 GetInstance(){
        return  singleton1;
    }

    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.GetInstance();
        Singleton1 singleton2 = Singleton1.GetInstance();
        System.out.println(singleton1==singleton2);

    }
}
