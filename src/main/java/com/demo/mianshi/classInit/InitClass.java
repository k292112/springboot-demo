package com.demo.mianshi.classInit;

/**
 * 类的初始化过程：
 * 1.先加载 静态资源（static修饰的成员变量 和代码块），
 * 2.然后调用赋值初始值，基本类型值为0，引用类型为null
 * 3.然后将方法符合（方法名） 引用转为 直接引用（方法地址指向）
 * 4. new 对象时候。给成员变量赋值。
 */
class Field1{
    public Field1(){
        System.out.println("Field1构造方法");
    }
}

public class InitClass extends Parent{
    private static int b = 2;
    private  int initA = 2;
    public static Field1 field2 = new Field1(); // static 多个对象公用一份
    static {
        System.out.println("static init..."+b);
    }
    InitClass(){
        System.out.println("init con..."+initA);
    }
    InitClass(int c){
        System.out.println("init con..."+c);
    }
}
class Parent{
    private static int a = 1;
    private static Field1 field1 = new Field1();
    static {
        System.out.println("static parent..."+a);
    }

    Parent(){
        System.out.println("parent con...");
    }

    public static void main(String[] args) {
        InitClass parent = new InitClass();// 先调用 父类static 然后子类 static，然后 父类构造方法，子类构造方法。
        InitClass parent2 = new InitClass();// 先调用 父类static 然后子类 static，然后 父类构造方法，子类构造方法。
        System.out.println(parent.field2 == parent2.field2);
    }
}