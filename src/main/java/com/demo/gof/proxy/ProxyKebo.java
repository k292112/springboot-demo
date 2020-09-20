package com.demo.gof.proxy;

public class ProxyKebo implements person{
    Kobe kobe = null;
    ProxyKebo(){
        kobe = new Kobe();
    }
    public void play(){
        System.out.println("通知科比打篮球");
        kobe.play();
        System.out.println("通知完毕");
    }
    public void play2(){
        System.out.println("通知科比打篮球22");
        kobe.play();
        System.out.println("通知完毕222");
    }
}
