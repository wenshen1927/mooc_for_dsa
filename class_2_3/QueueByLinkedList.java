package com.dsa.mooc.class_2_3;

import org.junit.Test;

/**
 * 用单向链表实现队列
 * 用链表实现队列不需要isFull()函数
 */

public class QueueByLinkedList {
    //链表的头结点,也是队列头节点，删除操作
    private Node front;
    //队列尾节点，插入操作
    private Node rear;
    //队列的节点数
    private int size;

    private class Node {
        private Object data;
        private Node next;

        public Node(Object obj) {
            data = obj;
            next = null;
        }
    }

    //初始化队列
    public QueueByLinkedList() {

    }

    //添加元素到队列
    public void insert(Object data) {
        Node node = new Node(data);
        if (isEmpty()) {//队列为空的时候，需要首先给front和rear赋值初始化
            front = node;
            rear = node;
            size++;
        } else {
            rear.next = node;
            rear = rear.next;
            size++;
        }
    }

    //删除队列头元素
    public void remove() {
        if (isEmpty()) {//队列为空
            throw new RuntimeException("队列为空");
        } else {//队列大于等于一个元素的时候
            front = front.next;
            size--;
        }
    }

    //判空
    public boolean isEmpty() {
        return (size == 0);
    }

    //遍历打印队列
    public void display() {
        int tempSize = size;
        Node tempFront = front;
        while (tempSize > 0) {
            System.out.print(tempFront.data + " ");
            tempFront = tempFront.next;
            tempSize--;
        }
        System.out.println();
    }

    //测试队列的两种实现方式：数组和链表，数组的插入速度更快，毕竟少创建了很多节点
    @Test
    public void test() {
        int N = 1000000;
        QueueByLinkedList queue = new QueueByLinkedList();
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            queue.insert(i);
        }
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);

        QueueByArray queueByArray = new QueueByArray(N);
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            queueByArray.insert(i);
        }
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - start2);
    }
}
