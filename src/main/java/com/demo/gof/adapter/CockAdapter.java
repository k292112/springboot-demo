package com.demo.gof.adapter;
//适配器
public class CockAdapter implements Duck{
    Cock cock;

    public CockAdapter(Cock cock) {
        this.cock = cock;
    }

    @Override
    public void quack() {
        //内部其实是一只鸡的咕咕叫
        cock.gobble();
    }

    @Override
    public void fly() {
        cock.fly();
    }
}
