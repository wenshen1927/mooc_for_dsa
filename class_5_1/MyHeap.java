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
     * 当前堆的大小
     */
    private int currentSize;
    /**
     * 堆最大的大小
     */
    private int maxSize;
    /**
     * 比较器：c.compare(根，叶子) > 0
     * 使用不同的比较器可以分别创建最大堆和最小堆
     */
    private Comparator<? super T> c;

    public MyHeap(T[] a, Comparator<? super T> c) {
        this.heap = a;
        this.c = c;
        this.maxSize = a.length;
        buildHeap();
    }

    public MyHeap(T[] a, int maxSize, Comparator<? super T> c) {
        this.heap = a;
        this.c = c;
        this.maxSize = maxSize;
        buildHeap();
    }

    /**
     * 创建堆：线性复杂度的创建方法：找到最后一个节点的父节点，从父节点开始，从右到左对每一个节点堆化
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
     * 堆化（从给定的索引开始,全部堆化）
     *
     * @param i
     */
    public void heapify(int i) {
        heapify(i, heap.length);

    }

    /**
     * 堆化（从给定索引开始，范围内堆化）
     *
     * @param i 根节点索引
     * @param size 堆化的范围
     */
    public void heapify(int i, int size) {
        int l = left(i);
        int r = right(i);
        int max = i;//首先默认根节点最大
        //找根节点、左子节点和右子节点（若左右子节点存在）之间的最大值
        if (l <= size && c.compare(heap[i], heap[l]) < 0) {//根节点和左子节点做判断
            max = l;//若左子节点更大（或更小），则max赋值为左子节点
        }
        if (r <= size && c.compare(heap[max], heap[r]) < 0) {//根节点和右子节点比较
            //若右子节点更大（或更小），则max指向右子节点
            max = r;
        }
        if (i == max) {//比较之后i(根节点)依然最大，则已经是堆化，返回函数
            return;
        }
        //否则交换i和max的索引,继续堆化
        swap(i, max);
        heapify(max, size);
    }

    /**
     * 向上调整，直到找到index应该在的位置
     *
     * @param index
     */
    private void trickleUp(int index) {
        int parent = parent(index);
        T t = heap[index];
        while (index > 0 && c.compare(heap[parent], heap[index]) < 0) {
            heap[parent] = heap[index];
            index = parent;
            parent = (parent - 1) / 2;
        }
        heap[index] = t;
    }

    public boolean isFull() {
        return (currentSize == maxSize);
    }

    /**
     * 插入元素
     *
     * @param t
     * @return
     */
    public boolean insert(T t) {
        if (isFull()) {
            try {
                throw new Exception("heap is full");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
        heap[currentSize] = t;
        trickleUp(currentSize++);
        return true;
    }

    public boolean isEmpty() {
        return (currentSize == 0);
    }

    /**
     * 删除第一个元素
     *
     * @return
     */
    public T remove() {
        if (isEmpty()) {
            System.out.println("heap is empty");
            return null;
        }
        T t = heap[0];
        heap[0] = heap[--currentSize];
        trickleDown(0);
        return t;
    }

    /**
     * 向下调整
     *
     * @param index
     */
    private void trickleDown(int index) {
        T top = heap[index];
        int largeIndex = 0;
        while (index < currentSize / 2) {
            int l = left(index);
            int r = l + 1;
            if (r <= currentSize && c.compare(heap[l], heap[r]) < 0) {//寻找左右节点之间大（小）的
                largeIndex = r;
            } else {
                largeIndex = l;
            }
            if (c.compare(heap[index], heap[largeIndex]) > 0) {//根节点比叶节点大（小）
                break;
            }
            heap[index] = heap[largeIndex];
            index = largeIndex;//根节点下调到较大（小）的子节点
        }
        heap[index] = top;
    }

    public void display() {
        for (int i = 0; i < currentSize; i++) {
            System.out.print(heap[i] + " ");
        }
    }

    public static void main(String[] args) {
        Integer[] temp = null;
        temp = new Integer[]{5, 2, 4, 6, 1, 3, 2, 6};
        temp = new Integer[]{16, 14, 8, 7, 9, 3, 2, 4, 1};

        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {//o1代表根节点，o2代表叶节点
                //生成最大堆使用o1-o2,生成最小堆使用o2-o1
                return o1 - o2;
            }
        };

        MyHeap maxHeap = new MyHeap(temp,  c);
//        maxHeap.insert(new Integer(17));
        maxHeap.display();
    }
}
