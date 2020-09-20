package com.demo.gof.proxy;

public class Kobe implements person{
    String name;
    int age;
    @Override
    public void play(){
        System.out.println("kebo打篮球");
    }
    public void play2(){
        System.out.println("kebo打篮球222");
    }
}
