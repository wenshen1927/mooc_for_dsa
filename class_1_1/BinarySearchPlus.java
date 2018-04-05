package com.dsa.mooc.class_1_1;

import java.util.Arrays;

/**
 * 二分查找，若没有搜索到
 * 返回（-1 - 应该在的位置）
 */

public class BinarySearchPlus {
    public static int search(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length - 1;
        int mid = -1;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (key > arr[mid]) {
                lo = mid + 1;
            } else if (key < arr[mid]) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return (-1 - mid);
    }


    public static void main(String[] args) {
        int[] a = {10, 4, 6, 5, 8, 17, 2, -2, 3};
        int[] b = {9, 13, 21, 23};
        int[] c = {4, 4, 11, 13};
        Arrays.sort(a);
        int[] d = {7, 6, 5, 4};
        System.out.println("input array is : ");
        for (int i = 0; i < d.length; i++) {
            System.out.print(d[i] + " ");
        }
        System.out.println();
        int index = search(d, 13);
        System.out.println("index of key is " + index);
    }
}
