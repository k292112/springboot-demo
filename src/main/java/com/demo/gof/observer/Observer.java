package com.demo.gof.observer;
// 观察者接口
public  abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
