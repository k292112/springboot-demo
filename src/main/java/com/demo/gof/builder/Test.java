package com.demo.gof.builder;

public class Test {
    public static void main(String[] args) {
        User tom = User.builder().name("tom").name(20).build();
        System.out.println(tom);
    }
}
