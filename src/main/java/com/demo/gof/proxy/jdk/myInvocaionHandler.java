package com.demo.gof.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class myInvocaionHandler implements InvocationHandler {

    private final Object obj;
    myInvocaionHandler(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("通知打篮球");
        Object result = method.invoke(obj,args);
        System.out.println("通知完毕");
        return result;
    }
}
