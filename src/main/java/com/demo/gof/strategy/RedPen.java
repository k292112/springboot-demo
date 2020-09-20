package com.demo.gof.strategy;

public class RedPen implements Strtegy{
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("用红笔画,radius:"+radius+",x:"+x+",y:"+y);

    }
}
