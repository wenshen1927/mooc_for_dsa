package com.dsa.mooc.class_1_1;

import java.util.Arrays;

/**
 * 二分查找的实现
 * 二分查找的最好的时间复杂度是O(1),也就是一开始就查到了；
 * 最坏的时间复杂度是O(logN).
 * 空间复杂度是O(N)
 */

public class BinarySearch {
    public static void main(String[] args) {
        int[] a = {10,4,6,5,8,17,2,-2,3};
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        int index = binarySearch(a, 8);
        System.out.println("index is "+index);
    }

    /**
     * 二分搜索
     * @param arr 有序数组
     * @param x 待搜索的的数
     * @return 待搜索的数的索引
     */
    public static int binarySearch(int[] arr,int x){
        int low = 0;
        int high = arr.length-1;
        int mid = -1;
        while (low < high){
            mid = low+(high-low)/2;
            System.out.println(mid);
            if (x>arr[mid]){
                low = mid+1;
            }else if (x<arr[mid]){
                high = mid-1;
            }else {
                return mid;
            }
        }
        return mid;
    }
}
