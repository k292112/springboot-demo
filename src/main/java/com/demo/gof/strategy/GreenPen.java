package com.demo.gof.strategy;

public class GreenPen implements Strtegy{
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("用绿笔画,radius:"+radius+",x:"+x+",y:"+y);

    }
}
