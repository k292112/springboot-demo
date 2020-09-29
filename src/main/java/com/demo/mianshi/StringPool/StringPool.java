package com.demo.mianshi.StringPool;

/**
 * 字符串常量池：
 * 1.字符串的 字面量= 会放入常量池，字面量比较== 是 true。
 * 2. new String(a) 如果常量池没有，放入一份a，同时自己会 new一份到堆。 ==比较为 false
 * 3. 相加：1.如果是 字符面+字符面 = 字符面  会优化相加的结果， == 比较为 true
 * 4. 想加：2.如果是 字符面+引用（字符面引用或者 new的引用）==比较为 false
 */
public class StringPool {
    public static void main(String[] args) {

        String a1 = "a";
        String b = new String(a1);
        System.out.println(b==a1); // false
        // 相加操作
        String c1 = "aa";
        String c = a1+b;// new + string
        System.out.println(c==c1);// 相加的包括new 是 false
        // 相加 不包括new
        String d3 ="dd";
        String d = "d"+"d";
        String d2 = d;
        System.out.println(d3==d); //true 字符串的字面相加会优化合并成一个字符串，所以为true
        String d4 ="d";
        String d5 = d4+"d";
        System.out.println(d3==d5); // false 因为相加里面有 引用


    }
}
