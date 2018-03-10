package com.dsa.mooc.class_2_2;

import org.junit.Test;

/**
 * 用数组来实现一个简单的堆栈
 * 缺点：1、堆栈的容量一旦初始化，就不可改变，可以考虑实现一个可以扩容的堆栈。
 *      2、由于是数组实现的，所以堆栈只能存储同一个类型的数据，可以考虑使用Object类型。
 *      3、可以改用链表就不需要初始化容量啦。
 */

public class StackByArray {
    private int[] arr;
    private int maxSize;
    private int top;//用top指针来构建数组的size

    //初始化一个堆栈
    public StackByArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        top = -1;
    }

    //入栈
    public void push(int data) {
        if (top < maxSize - 1) {//栈未满，可以入栈
            arr[++top] = data;//top先加1，在做数组赋值
        }
    }

    //出栈
    public int pop() {
        return arr[top--];
    }

    //访问栈顶数据
    public int peek() {
        return arr[top];
    }

    //判断栈是否为空
    public boolean isEmpty() {
        return (top == -1);
    }

    //判断栈是否满了
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    //遍历栈数据
    public void display() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

}

class TestStack {
    public static void main(String[] args) {
        StackByArray sba = new StackByArray(3);
        sba.push(1);
        sba.push(2);
        sba.push(4);
        sba.push(5);
        sba.display();
        System.out.println(sba.pop());
        System.out.println(sba.pop());
        System.out.println(sba.pop());

        System.out.println(sba.isEmpty());
        System.out.println(sba.isFull());

        sba.push(1);
        sba.push(2);
        sba.push(4);
        sba.push(5);
        System.out.println(sba.isEmpty());
        System.out.println(sba.isFull());
    }
}

