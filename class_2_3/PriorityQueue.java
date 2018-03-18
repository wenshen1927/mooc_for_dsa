package com.dsa.mooc.class_2_3;

import org.junit.Test;

/**
 * 1、优先级队列（priority queue）是比栈和队列更专用的数据结构，（有序队列）
 * 在优先级队列中，数据项按照关键字进行排序，关键字最小（或者最大）的数据项往往在队列的最前面，
 * 而数据项在插入的时候都会插入到合适的位置以确保队列的有序。
 * 2、用无序数组实现一个优先级队列。由于使用无序数组，插入的时候可以直接插入到数组最后,复杂度是O(1)，
 * 但是查找最值的时候需要O(n)的复杂度
 * 3、相反，如果用有序数组，那么插入的复杂度是O(n)，查找最值的复杂度是O(1).
 * 4、这里用有序数组实现（后面会用堆来实现优先级队列，速度更好）。
 */

public class PriorityQueue {
    private int[] queue;
    private int maxSize;
    private int size;
    private int DEFAULT_SIZE = 4;

    public PriorityQueue() {
        this.maxSize = DEFAULT_SIZE;
        queue = new int[maxSize];
        size = 0;
    }

//    public PriorityQueue(int maxSize) {
//        this.maxSize = maxSize;
//        queue = new int[maxSize];
//        size = 0;
//    }

    //插入数据，按照从大到小的顺去排列，越小的排在队列的顶端。
    public void insert(int data) {
        int j;
        if (size == 0) {
            queue[size++] = data;
        } else {
            j = size - 1;//用一个临时变量来帮助遍历这个队列,大的往后退（数组序列减少）
            while (j >= 0 && data > queue[j]) {
                queue[j + 1] = queue[j];
                j--;
            }
            queue[j + 1] = data;
            size++;

        }
    }

    //移除数据
    public int remove() {
        int value = queue[size - 1];
        queue[size - 1] = -1;//移除的位置赋值为-1；如果是引用类型就设置为null
        size--;
        return value;
    }

    //返回最值
    public int peekMin() {
        return queue[size - 1];
    }

    //判空
    public boolean isEmpty() {
        return (size == 0);
    }

    //判满
    public boolean isFull() {
        return (size == maxSize);
    }

    //打印遍历
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    @Test
    public void test() {
        PriorityQueue queue = new PriorityQueue();
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.display();

        System.out.println(queue.remove());
        System.out.println(queue.remove());

        queue.display();
    }
}
