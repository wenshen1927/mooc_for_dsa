package com.dsa.mooc.class_3_1;

import java.util.Arrays;

/**
 * 二分查找,时间复杂度是O(nlog(n))
 * 二分查找形成了一个层次结构，形成一个判定树，判定书上每个节点需要的查找此时刚好为该节点所在的层数。
 * 查找成功时的查找次数不会超过判定书的深度。n个节点的判定书的深度为[log(n)+1]
 * <p>
 * 这里使用黄金分割查找，也就是 mid = left+0.618(right - left)
 * 并且比较它和二分法的效率.
 * 黄金分割的效率要低一些，可能是要进行浮点数运算会增加计算时间。
 */

public class GodenRatioBinarySearch {
    public int search(int[] arr, int value) {
        int lo = 0;
        int hi = arr.length - 1;
        int mid;
        while (lo < hi) {
            mid = lo + (int) 0.618 * (hi - lo);
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

        int N = 100000000;
        int[] arr = new int[N];
        int value = 200;
        int index1 = -1;
        int index2 = -1;
        int iteration = 10000;//迭代次数
        //构造数组
        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }

        BinarySearch bin = new BinarySearch();
        GodenRatioBinarySearch go = new GodenRatioBinarySearch();

        long start1 = System.currentTimeMillis();
        for (int i = 0; i < iteration; i++) {
            index1 = bin.search(arr, value);
        }
        long end1 = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < iteration; i++) {
            index2 = go.search(arr, value);
        }
        long end2 = System.currentTimeMillis();

        System.out.println("结果1：" + index1 + " 结果2：" + index2);
        System.out.println("N为：" + N);
        System.out.println("二分查找的时间：" + (end1 - start1));
        System.out.println("黄金分割查找的时间：" + (end2 - start2));

    }
}


