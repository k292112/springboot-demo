package com.demo.gof.adapter;

public class Test {

    public static void main(String[] args) {
        Cock cock = new WildCock();//鸡
        Duck duck = new CockAdapter(cock);//鸡 适配鸭
        duck.fly();//鸭的飞
        duck.quack();//鸭的叫
    }
}
