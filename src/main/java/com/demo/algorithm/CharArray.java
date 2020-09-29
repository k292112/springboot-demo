package com.demo.algorithm;

/**
 * char[] 数组 如果里面存的是数字(ASCCI码)，那取出来就是数字对于的值,
 * 如果存的本事就是 字符，那取出来的就是字符。
 */
public class CharArray {
    public static void main(String[] args) {
        char [] c = {'A',65,70}; //AAF
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }
        String s = String.valueOf(c);//忽略为null的值的
        System.out.println(s);
    }
}
