package com.dsa.mooc.class_3_1;

/**
 * 引子1：
 * 顺序查找，时间复杂度是O(n)
 * 有哨兵的顺序查找,可以减少一次逻辑判断，但是需要创建新的结构体（类）。
 */

public class SequenceSearch {

    /**
     * 顺序查找，若返回0，表示不存在
     *
     * @param arr
     * @param value
     * @return
     */
    public static int search(int[] arr, int value) {
        //从后往前顺序查找，直到查找到设定的值
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, -2, 3, 4, -5};
        int k = -2;
        int i = search(arr, k);
        System.out.println(i);
    }
}
