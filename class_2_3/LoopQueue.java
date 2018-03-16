package com.dsa.mooc.class_2_3;

/**
 * 用数组实现循环队列
 * 一般的队列对数组空间的利用不好，比如删除了头部的几个数据，那么头部的空间就空出来了，无法得到利用
 * 循环队列就是在头部有空间的时候，也可以把数据插入进去。
 * 循环队列的实现方法：
 * 1、实现插入循环：(front+1)%size;
 * 2、如何判断front==rear是满还是空：（1）添加一个变量size，用于记录队列的长度；（2）仅适用n-1个数组空间，这样front==rear就代表空。
 *
 */

public class LoopQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int maxSize;
    private int size;

    public LoopQueue(int maxSize) {
        this.maxSize = maxSize;
        queue = new int[maxSize];
        front = 0;
        rear = 0;
    }

    //插入数据
    public boolean insert(int data) {
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        queue[rear] = data;
        rear = (rear + 1) % maxSize;
        size++;
        return true;
    }

    //删除数据
    public int remove() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        } else {
            int temp = queue[front];
            front = (front + 1) % maxSize;
            size--;
            return temp;
        }
    }

    //判断是否为空
    public boolean isEmpty() {
        return (size == 0);
    }

    //判断是否为满
    public boolean isFull() {
        return (size == maxSize);
    }

    //返回队列长度
    public int getSize() {
        return size;
    }

    //遍历循环队列
    public void display() {
        int tempFront = front;
        if ((tempFront == rear) && (size == 0)) {
            throw new RuntimeException("队列为空");
        } else {
            System.out.print("从队头到队尾为： ");
            do {
                System.out.print(queue[tempFront] + " ");
                tempFront = (tempFront + 1) % maxSize;
            } while (tempFront != rear);
            System.out.println();
        }

    }

}

class TestLoopQueue {
    public static void main(String[] args) {
        LoopQueue queue = new LoopQueue(4);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        queue.insert(6);
        queue.display();

        System.out.print(queue.remove() + " ");
        System.out.print(queue.remove() + " ");
        System.out.print(queue.remove() + " ");
        System.out.println();
        queue.display();

        queue.insert(4);
        queue.insert(7);
        queue.insert(8);
//        queue.insert(8);
        queue.display();
    }
}
