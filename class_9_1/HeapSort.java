package com.dsa.mooc.class_9_1;

/**
 * todo
 * 重新实现一下堆排序(不用tickleUp的方式（在第一次建完堆之后，很多叶子节点和其父节点是有严格大小关系的，所以无需比较），
 * 用tickleDown的方式可以省去很多（大概一半）的比较次数)
 */
public class HeapSort {
    public static void heapSort(int[] arr) {
        //1、首先对数组建最大堆O（n）;
        buildMaxHeap(arr);
        PrintUtil.print(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            //2、交换堆顶和数组末尾的数字;
            swap(arr, 0, i);
            //3、重建调整后的最大堆；
            maxHeapify(arr, 0, i);
        }
    }


    private static void buildMaxHeap(int[] arr) {
        int endIndex = parent(arr.length);
        for (int i = endIndex; i >= 0; i--) {
            maxHeapify(arr, i, arr.length);
        }
    }


    private static void maxHeapify(int[] arr, int root, int heapSize) {
        int intMax = root;
        int left = leftChild(root);
        int right = rightChild(root);
        while (true) {
            if (left < heapSize && arr[left] > arr[intMax]) {
                intMax = left;
            }
            if (right < heapSize && arr[right] > arr[intMax]) {
                intMax = right;
            }
            if (intMax != root) {
                swap(arr, root, intMax);
            } else {
                break;
            }
            root = intMax;
            left = leftChild(root);
            right = rightChild(root);
        }
    }

    private static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = arr[i1];

    }

    private static int parent(int index) {
        return (index + 1) / 2 - 1;
    }

    private static int rightChild(int index) {
        return (index + 1) * 2 - 1;
    }

    private static int leftChild(int index) {
        return (index + 1) * 2 ;
    }

    public static void main(String[] args) {
        int[] data = Data.generateRandomDate(10, 10000);
        PrintUtil.print(data);
        long start = System.currentTimeMillis();
        heapSort(data);
        long end = System.currentTimeMillis();
        System.out.println("time" + (end - start));
        PrintUtil.print(data);
    }
}
