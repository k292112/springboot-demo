package com.demo.gof.strategy;

/**
 * 策略类
 */
public class Context {
    Strtegy strtegy;

    public Context(Strtegy strtegy) {
        this.strtegy = strtegy;
    }
    public void executeDraw(int radius,int x,int y){
        strtegy.draw(radius,x,y);
    }
}
