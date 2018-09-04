package com.dsa.mooc.class_9_1;

public class InsertSort {
    /**
     * 插入排序
     * 时间复杂度分析：最好o(n),最坏o(n^2)
     *
     * @param arr
     */
    public static void insertSort(int[] arr, int left, int right) {
        int count = 0;//记录比较的次数
        for (int i = left; i < right; i++) {
            int temp = arr[i];//摸下一张牌
            int j = 0;
            for (j = i; j > 0 && arr[j - 1] > temp; j--) {
                arr[j] = arr[j - 1];
                count++;
            }
            arr[j] = temp;
        }
//        System.out.println("count:" + count);
    }

    public static void main(String[] args) {
        int[] data = Data.generateRandomDate(10, 100);
        int[] dataA = new int[]{34, 8, 64, 51, 32, 21};
        PrintUtil.print(dataA);
        insertSort(dataA,0,dataA.length);
        PrintUtil.print(dataA);
    }


}
