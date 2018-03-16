package com.dsa.mooc.class_2_3;

/**
 * 想象成排队，队伍进人的时候总是从后面排队加入，队伍出人的时候总是从队头出去
 * 队列一般用front表示队列头（进行删除操作的一端），用rear表示队列尾（进行插入操作的一端）
 * 用数组实现单向队列：只在一端插入数据，另一端删除数据
 */

public class QueueByArray {
    private int front;//队列头
    private int rear;//队列尾

    private int[] queue;

    private int maxSize;//队列的总大小

    public QueueByArray(int maxSize) {
        this.maxSize = maxSize;
        queue = new int[maxSize];
        front = -1;
        rear = -1;
    }

    //入队
    public boolean insert(int data) {
        if (isFull()) {
            System.out.println("队列已满");
        } else if (isEmpty()) {
            front = 0;//当队列为空的时候，插入第一个元素时，front和rear指向同一个元素
        }
        queue[++rear] = data;
        return true;
    }

    //出队
    public int remove() {
        int temp = queue[front];
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        } else {
            front++;
        }
        return temp;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return (rear == front);
    }

    //判断队列是否为满
    public boolean isFull() {//只要rear达到队列最大边界，就表示队列已满
        return (rear == (maxSize - 1));
    }

    //查看队头数据
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        } else {
            return queue[front];
        }
    }

    //查看队列size
    public int getSize() {
        return (rear - front);
    }

    //遍历队列元素
    public void display() {
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}

class TestQueue {
    public static void main(String[] args) {
        QueueByArray queue = new QueueByArray(5);
        queue.insert(0);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
//        queue.insert(5);//队列已满
        queue.display();

        queue.remove();
        queue.remove();
        queue.display();
    }
}
