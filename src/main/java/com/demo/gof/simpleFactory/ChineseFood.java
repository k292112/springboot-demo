package com.demo.gof.simpleFactory;

public class ChineseFood implements Food{

    @Override
    public void disc() {
        System.out.println("中国食物！！！");
    }

    public ChineseFood() {
        System.out.println("中国食物！！！");
    }
}
