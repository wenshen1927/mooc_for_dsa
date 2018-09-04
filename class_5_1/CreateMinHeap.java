package com.dsa.mooc.class_5_1;

/**
 * 最小堆的创建方法
 */
public class CreateMinHeap {

    /**
     * 将数组构建成为最小堆
     *
     * @param arr
     */
    public static void minHeapify(int[] arr) {

        int len = arr.length;
        for (int i = len - 1; i >= 0; i--) {//o(n)
            tickleUp(arr, i);
        }
    }

    private static void tickleUp(int[] arr, int index) {
        int parent = (index - 1) / 2;
        if (parent >= 0 && arr[parent] > arr[index]) {
            swap(arr, parent, index);
            index = parent;
            tickleUp(arr, index);
        }
    }

    private static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 2, 6, 1, 7, 4};

        minHeapify(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
