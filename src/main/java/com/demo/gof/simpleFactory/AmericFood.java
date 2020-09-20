package com.demo.gof.simpleFactory;

public class AmericFood implements Food{
    public  AmericFood() {
        System.out.println("美国食物！！！");
    }

    @Override
    public void disc() {
        System.out.println("美国食物！！！");
    }
}
