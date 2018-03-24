package com.dsa.mooc.class_3_1;

import java.util.Arrays;

/**
 * 二分查找,时间复杂度是O(nlog(n))
 * 二分查找形成了一个层次结构，形成一个判定树，判定书上每个节点需要的查找此时刚好为该节点所在的层数。
 * 查找成功时的查找次数不会超过判定书的深度。n个节点的判定书的深度为[log(n)+1]
 */


public class BinarySearch {
    /**
     * 必须放在数组里面，必须是有序数组
     *
     * @param arr
     * @param value
     * @return
     */
    public  int search(int[] arr, int value) {
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
//        int i = search(arr, k);
//        System.out.println(i);
    }
}
