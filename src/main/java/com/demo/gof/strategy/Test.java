package com.demo.gof.strategy;

public class Test {

    public static void main(String[] args) {
        Context context = new Context(new RedPen());
        context.executeDraw(10,0,0);
    }
}
