package com.dsa.mooc.class_9_1;

import com.dsa.mooc.class_1_1.PrintN;

/**
 * 冒泡排序
 */
public class BubbleSort implements Sort {
    @Override
    public void sort(int[] arr) {

    }

    public static void sort(int[] arr, int start, int end) {
        if (arr == null) {
            return;
        }

        int count = 0;//记录比较的次数
        for (int i = arr.length - 1; i >= 0; i--) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                    count++;
                }
            }
            if (!flag) {
                System.out.println("bubble sort count:" + count);
                return;
            }
        }
        System.out.println("bubble sort count:" + count);
    }

    public static void main(String[] args) {
        int[] data = Data.generateRandomDate(10, 100);
        int[] dataA = new int[]{34, 8, 64, 51, 32, 21};
        PrintUtil.print(dataA);
        sort(dataA, 0, 0);
        PrintUtil.print(dataA);
    }
}
