package com.demo.gof.observer;

public class Test {
    public static void main(String[] args) {
        // 定义一个 主题 （被监视着）
        Subject subject  = new Subject();
        // 二进制观察者 订阅主题
        new BinaryObserver(subject);
        // 十六进制观察者 订阅主题
        new HexaObserver(subject);
        // 主题变更通知
        subject.setState(10);
    }
}
