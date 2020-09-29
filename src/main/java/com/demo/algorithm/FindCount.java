package com.demo.algorithm;

/**
 * 字符串 A00B00C000D0 , 如果有 k个0，求去掉k个0的 字符串。即 2个0  ABC000D0
 */
public class FindCount {
    public static void main(String[] args) {
        String s = removeKZeros2("A00C000D00", 2);
        System.out.println(s);
    }

    //返回去掉k个0后的字符串
    public static String removeKZeros2(String str, int k) {
        if (str == null || k < 1) {
            return str;
        }
        //字符串转换成数组
        char[] ch = str.toCharArray();
        int count = 0;//记录0出现的次数
        int start = -1; //记录0出现的位置
        for (int i = 0; i < ch.length; i++) {//A00C000D0
            if (ch[i] == '0') {
                count++;
                start = start == -1 ? i : start;//重复的00只记录第一个0位置
                System.out.println(start);
            } else {
                if (count == k) {
                    while (count-- != 0) {
                        ch[start++] = 0; //null的ascci码为0
                    }
                }
                count = 0;
                start = -1;
            }

        }
        // 避免 字符串最后是 k个0
        if (count == k) {
            while (count-- != 0) {
                ch[start++] = 0;
            }

        }
        //数组转换成字符串
        return String.valueOf(ch);
    }
}
