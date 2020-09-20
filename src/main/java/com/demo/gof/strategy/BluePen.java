package com.demo.gof.strategy;

public class BluePen implements Strtegy{
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("用蓝笔画,radius:"+radius+",x:"+x+",y:"+y);

    }
}
