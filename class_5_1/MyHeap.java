package com.dsa.mooc.class_5_1;

import java.util.Comparator;

/**
 * 重写堆
 */

public class MyHeap<T> {
    /**
     * 用数组来存储堆元素
     */
    private T[] heap;

    /**
     * 比较器：c.compare(根，叶子) > 0
     * 使用不同的比较器可以分别创建最大堆和最小堆
     */
    private Comparator<? super T> c;

    public MyHeap(T[] a, Comparator<? super T> c) {
        this.heap = a;
        this.c = c;
        buildHeap();
    }

    /**
     * 创建堆：线性复杂度的创建方法
     */
    private void buildHeap() {
        for (int i = heap.length / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    /**
     * 返回当前节点索引的父节点索引
     *
     * @param i
     * @return
     */
    private int parent(int i) {
        return (i - 1) >> 1;
    }

    /**
     * 返回当前节点索引的左子节点索引
     *
     * @param i
     * @return
     */
    private int left(int i) {
        return ((i + 1) << 1) - 1;//这样先加1，能够避免i==0时出现的问题
    }

    /**
     * 返回当前节点索引的右子节点索引
     *
     * @param i
     * @return
     */
    private int right(int i) {
        return (i + 1) << 1;
    }

    /**
     * 交换索引为i,j的节点的值(注意交换的是值，而不是索引)
     *
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        T tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    /**
     * 堆化（从给定的索引开始）
     *
     * @param i
     */
    public void heapify(int i) {
        heapify(i, heap.length);

    }

    /**
     * 堆化
     *
     * @param i
     * @param size 堆化的范围
     */
    public void heapify(int i, int size) {
        int l = left(i);
        int r = right(i);
        int next = i;
        if (l <= size && c.compare(heap[i], heap[l]) < 0) {//根节点和左子节点做判断
            next = l;//若左子节点更大（或更小），则next指向左子节点
        }
        if (r <= size && c.compare(heap[next], heap[r]) < 0) {//左子节点和右子节点比较
            //若右子节点更大（或更小），则next指向右子节点
            next = r;
        }
        if (i == next) {//若变换之后i(根节点)依然最大,否则交换i和next的索引
            return;
        }
        swap(i, next);
        heapify(next, size);
    }

    //插入元素

    //删除元素
    
    public static void main(String[] args) {
        Integer[] temp = null;
        temp = new Integer[]{5, 2, 4, 6, 1, 3, 2, 6};
        temp = new Integer[]{16, 14, 8, 7, 9, 3, 2, 4, 1};

        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //生成最大堆使用o1-o2,生成最小堆使用o2-o1
                return o1 - o2;
            }
        };

        MyHeap maxHeap = new MyHeap(temp, c);


    }
}
