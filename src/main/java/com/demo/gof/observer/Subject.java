package com.demo.gof.observer;

import java.util.ArrayList;
import java.util.List;

// 主题
public class Subject {
    //所有观察者对象
   private final List<Observer> observers = new ArrayList<Observer>();
   // 数据变更通知
   private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        // 数据变更，通知
        notifyAllObserver();
    }
    //注册 观察者
    public void attach(Observer observer){
        observers.add(observer);
    }
//    通知观察者
    public void notifyAllObserver(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
