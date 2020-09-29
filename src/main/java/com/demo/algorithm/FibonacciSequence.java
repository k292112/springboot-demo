package com.demo.algorithm;

/**
 * 斐波那契数列（Fibonacci sequence），又称黄金分割数列、
 * 因数学家莱昂纳多·斐波那契（Leonardoda Fibonacci）以兔子繁殖为例子而引入，故又称为“兔子数列”，
 * 指的是这样一个数列：0、1、1、2、3、5、8、13、21、34、……  求第N位的数是多少？？
 * 这个数列从第3项开始，每一项都等于前两项之和。
 */
public class FibonacciSequence {
    public static void main(String[] args) {
        // 1利用循环
        long count = fibonacci(50);
        System.out.println(count);
        // 2递归 效率低下 时间耗费久
        long count2 = fibonacci2(50);
        System.out.println(count2);
    }
    // 1 利用循环
    public static Long fibonacci(int count){
        if(count <= 0){
            return 0l;
        }
         if(count == 1){
             return 1l;
         }
        // 1. 循环N位，每次循环记录前两个数，然后 当前数=前2个数相加，赋值给前一个数，前一个数给前前个数。
        long a = 1l;// 前前一个数
        long b = 1l;// 前一个数
        long c = 0l;// 当前数
        for (int i = 2; i <count; i++) {
            // 获取当前值
            c = a +b;
            // 前一个给前前一个
            a = b;
            // 当前值给 前一个
            b = c;
        }
        return b;
    }
    // 2 使用递归
    public static long fibonacci2(long count){
        if(count <= 0){
            return 0l;
        }
        if(count == 1l){
            return 1l;
        }
        return fibonacci2(count-2l) + fibonacci2(count -1l);
    }
}
