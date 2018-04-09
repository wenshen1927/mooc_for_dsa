package com.dsa.mooc.class_5_1;

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
    //判空
    public boolean isEmpty() {
        return (currentSize == 0);
    }

    //判满
    public boolean isFull() {
        return (currentSize == maxSize);
    }
    //插入（最大堆）
    //删除最大值（最大堆）

    //遍历与查找
    //堆基本上是无序的，所以难以遍历或者查找。但是能快速地移除最大值或者插入新的节点。

}
