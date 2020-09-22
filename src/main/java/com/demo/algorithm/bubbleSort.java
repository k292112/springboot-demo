package com.demo.algorithm;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class bubbleSort {
    public static void main(String[] args) {
        int arr[] = {1,3,2,4,66,4,21,33,11};
        bubbleSortDemo(arr);
        System.out.println(Arrays.toString(arr));
    }
    // 冒泡排序 升序
    public static void  bubbleSortDemo(int[] arr){
        int temp = 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]){// 升序
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

}
