package com.dsa.mooc.class_9_1;


import org.junit.Test;

/**
 * 希尔排序（经典做法）
 */
public class ShellSort {
    //非递归地形式
    public void shellSort(int[] arr) {
        int len = arr.length;
        for (int step = len / 2; step > 0; step = step / 2) {//i表示步长
//            System.out.println("step " + step);

            //下面就是针对每个步长的插入排序
            for (int i = step; i < len; i++) {
                int temp = arr[i];
                int j = 0;
                for (j = i; j >= step && arr[j - step] > temp; j -= step) {
                    arr[j] = arr[j - step];
                }
                arr[j] = temp;
            }
            PrintUtil.print(arr);
        }
    }

    /**
     * Hibbard增量序列
     */

    /**
     * 递归的做法
     *
     * @param arr
     * @param step
     */
    public void shellSort(int[] arr, int step) {
        if (step < 1) {
            return;
        }
        //插入排序
        for (int i = step; i < arr.length; i++) {
            int temp = arr[i];
            int j = 0;
            for (j = i; j >= step && arr[j - step] > temp; j -= step) {
                arr[j] = arr[j - step];
            }
            arr[j] = temp;
        }
        shellSort(arr, step / 2);
    }

    @Test
    public void testShellSort() {
        int[] arr = Data.generateRandomDate(100000, 100000);
        long start = System.currentTimeMillis();
        shellSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("run time : " + (end - start));
        PrintUtil.print(arr);
    }


}
