package com.dsa.mooc.class_3_1;

import java.util.Arrays;

/**
 * 二分查找,时间复杂度是O(nlog(n))
 */


public class BinarySearch {
    /**
     * 必须放在数组里面，必须是有序数组
     *
     * @param arr
     * @param value
     * @return
     */
    public static int search(int[] arr, int value) {
        int lo = 0;
        int hi = arr.length - 1;
        int mid;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (arr[mid] > value) {
                hi = mid - 1;
            } else if (arr[mid] < value) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 2, 5, 1, -2, -4, 3, 1};
        int k = -9;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        int i = search(arr, k);
        System.out.println(i);
    }
}
