package com.dsa.mooc.class_9_1;

import javafx.scene.shape.MoveToBuilder;

import java.util.*;

/**
 * 快速排序
 */
public class FastSort {
    public void fastSort(int[] arr, int left, int right) {
        //三种选择主元的方式
        //1、选择数组左、中、右三个数中中间大小的数作为主元
        int pivot = median3(arr, left, right);//中位数是最有效率的（相比选择第一个和随机数）
        //2、选择数组第一个元素作为主元
//        int pivot = firstA(arr, left);
        //3、选择数组中随机的一个元素作为主元（随机计算也需要时间）
//        int pivot = randomA(arr, left, right);
        int cutOff = 100;
        if (cutOff <= (right - left)) {//如果待排规模在cutOff以上的话，就用快排，否则使用插入排序等其他排序方式
            //用两个指针分别指向头和尾
            int low = left;
            int high = right - 1;
            while (true) {
                while (arr[++low] < pivot) ;
                while (arr[--high] > pivot) ;
                if (low < high) {
                    swap(arr, low, high);
                } else {
                    break;
                }
            }
            swap(arr, low, right - 1);
            fastSort(arr, left, low - 1);
            fastSort(arr, low + 1, right);
        } else {
            InsertSort.insertSort(arr, left, right + 1);
        }

    }

//    private int randomA(int[] arr, int left, int right) {
//        Random random = new Random();
//        return random.nextInt(left + (right - left));
//    }

    /**
     * 选择数组中左、中、右，三个数里面大小为中间的那个数作为主元（pivot）
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private int median3(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        if (arr[left] > arr[mid]) {
            swap(arr, left, mid);
        }
        if (arr[left] > arr[right]) {
            swap(arr, left, right);
        }
        if (arr[mid] > arr[right]) {
            swap(arr, mid, right);
        }
        //经过交换，A[LEFT]<A[MID]<A[RIGHT]
        swap(arr, mid, right - 1);//将pivot藏在right-1的位置，right的位置已经是排好序的最大值了
        return arr[right - 1];
    }

    private int firstA(int[] arr, int left) {
        return arr[left];
    }

    private void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    public static void main(String[] args) {
        int[] data = Data.generateRandomDate(10000, 10000);
        FastSort fs = new FastSort();
        long start = System.currentTimeMillis();
        fs.fastSort(data, 0, data.length - 1);
        long end = System.currentTimeMillis();
        System.out.println("time" + (end - start));
        PrintUtil.print(data);
    }
}
