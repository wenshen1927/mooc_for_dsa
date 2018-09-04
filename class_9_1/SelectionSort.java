package com.dsa.mooc.class_9_1;

import org.junit.Test;

/**
 * 选择排序
 */
public class SelectionSort {
    public void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //1、选择最小元---这部分的时间复杂度是O(n^2)。所以这个算法的瓶颈在于如何选择最小元。
            int minPos = findMinPosition(arr, i, arr.length - 1);
            //2、交换最小元和当前元素位置---这部分的时间复杂度是O(n)
            swap(arr, i, minPos);
        }

    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private int findMinPosition(int[] arr, int start, int end) {
        int min = start;
        for (int i = start; i < end; i++) {
            if (arr[i] < arr[min]) {
                min = i;
            }
        }
        return min;
    }

    @Test
    public void testSelectSort() {
        int[] data = Data.generateRandomDate(10, 50);
        PrintUtil.print(data);
        selectSort(data);
        PrintUtil.print(data);
    }
}
