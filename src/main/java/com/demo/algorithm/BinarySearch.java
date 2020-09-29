package com.demo.algorithm;
/*
二分查找算法
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,3,4,5,7,8,12,16};
        int e = 17;
        // 1.while 循环
        int index = GetBinarySearch(e,arr);
        System.out.println(index);
        // 2.递归
        int index2 = recursion(0,arr.length-1,arr,e);
        System.out.println(index2);

    }
    public static int GetBinarySearch(int e,int []arr){
        int lo = 0;
        int hi = arr.length-1;
        int middle = 0;
        while (lo<=hi){
            middle = (lo+hi)/2;
            if(e == arr[middle]){
                return middle;
            }
            if (e > arr[middle]) {
                lo = middle+1;
            }
            if (e < arr[middle]) {
                hi = middle-1;
            }
        }
        return -1;
    }
    //递归调用
    public static int recursion(int lo,int hi,int[]arr,int e){
        int middle = (lo+hi)/2;
        if(e == arr[middle]){
            return middle;
        }
        if(e > arr[middle]){
            lo = middle+1;
        }
        if(e < arr[middle]){
            hi = middle-1;
        }
        if(lo<=hi){
            recursion(lo,hi,arr,e);
        }
        return -1;
    }
}
