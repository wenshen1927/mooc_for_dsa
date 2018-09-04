package com.dsa.mooc.class_9_1;


/**
 * 归并排序
 * <p>
 * 核心：有序子序列的归并，如两个有序数组或两个有序链表归并
 */
public class MergeSort {

    public static void mergeSort(int[] arr, int low, int high) {
        if (high == low) {
            return;
        }
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] arr, int leftStart, int rightStart, int rightEnd) {
        int leftEnd = rightStart - 1;
        int len = rightEnd - leftStart + 1;
        int[] temp = new int[len];
        int tempIndex = 0;
        while (leftStart <= leftEnd && rightStart <= rightEnd) {
            if (arr[leftStart] <= arr[rightStart]) {
                temp[tempIndex++] = arr[leftStart++];
            } else {
                temp[tempIndex++] = arr[rightStart++];
            }
        }
        while (leftStart <= leftEnd) {
            temp[tempIndex++] = arr[leftStart++];
        }
        while (rightStart <= rightEnd) {
            temp[tempIndex++] = arr[rightStart++];
        }
        for (int i = len - 1; i >= 0; i--, rightEnd--) {
            arr[rightEnd] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
        mergeSort(arr, 0, arr.length - 1);
        PrintUtil.print(arr);
    }
}
