package com.demo.gof.proxy.jdk;

import com.demo.gof.proxy.Kobe;
import com.demo.gof.proxy.Yao;
import com.demo.gof.proxy.person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 目前Java开发包中包含了对动态代理的支持，但是其实现只支持对接口的的实现。
 * 其实现主要通过java.lang.reflect.Proxy类和java.lang.reflect.InvocationHandler接口。
 * Proxy类主要用来获取动态代理对象，InvocationHandler接口用来约束调用者实现
 */
public class Test {
    public static void main(String[] args) {
        person p = new Kobe();
        InvocationHandler invocationHandler = new myInvocaionHandler(p);
        person kobe = (person) Proxy.newProxyInstance(p.getClass().getClassLoader(),p.getClass().getInterfaces(),invocationHandler);
        kobe.play();

        // yao 打篮球
        person yao = new Yao();
        InvocationHandler yaoInvocationHandler = new myInvocaionHandler(yao);
        person yaoProxy = (person) Proxy.newProxyInstance(p.getClass().getClassLoader(),yao.getClass().getInterfaces(),yaoInvocationHandler);
        yaoProxy.play();
    }
}
