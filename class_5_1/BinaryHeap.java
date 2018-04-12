package com.dsa.mooc.class_5_1;

import com.dsa.mooc.class_4_1.BinSearchTree;

/**
 * 堆：（以最大堆为例）
 * 1、完全二叉树（用数组表示）2、关键字的最大值在根节点上
 */

public class BinaryHeap {

    private Node[] heapArray;//存储堆元素的数组
    private int maxSize;//堆的容量
    private int currentSize;//堆中当前元素的个数

    private class Node {
        private int data;

        public Node(int data) {
            this.data = data;
        }
    }

    //创建堆
    public BinaryHeap(int max) {
        this.maxSize = max;
        currentSize = 1;//默认是1
        heapArray = new Node[maxSize + 1];//数组0的位置设为哨兵
        heapArray[0] = new Node(Integer.MAX_VALUE);//哨兵：数组第一个位置，值为最大值
    }

    //判空
    public boolean isEmpty() {
        return (currentSize == 1);
    }

    //判满
    public boolean isFull() {
        return (currentSize == maxSize + 1);
    }

    //插入（最大堆）
    public boolean insert(int key) {
        Node node = new Node(key);
        if (isFull()) {
            System.out.println("Insert Error:heap is full");
            return false;
        }
        //先插进来
        heapArray[++currentSize] = node;

        //再判断是否要交换数字
        for (int i = currentSize; heapArray[i].data > heapArray[i / 2].data; i /= 2) {
            int tempData = heapArray[i / 2].data;
            heapArray[i].data = heapArray[i / 2].data;
            heapArray[i / 2].data = tempData;
        }
        return true;
    }


    //删除最大值（最大堆）

    //遍历与查找
    //堆基本上是无序的，所以难以遍历或者查找。但是能快速地移除最大值或者插入新的节点。


}
