package com.dsa.mooc.class_2_2;

/**
 * 用一个数组实现两个堆栈，要求最大地利用数组空间，使数组只要有空间入栈操作就可以成功
 * 思路是，两个栈分别从数组的两头开始向中间生长，当两个栈的栈顶指针相遇时，表示两个栈满了.
 * 也就是数组的两端作为栈底，中间的某个地方作为栈口。
 */

public class TwoStackByOneArray {

    private int maxSize;
    private int[] arr;
    private int top1;
    private int top2;

    public TwoStackByOneArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];//生成一个默认数组，默认空位为0；
        top1 = -1;
        top2 = maxSize;
    }

    public void push1(int data) {
        if ((top1 + 1) != top2) {
            arr[++top1] = data;
        } else {
            System.out.println("Error:Stack is full");
        }
    }

    public void push2(int data) {
        if ((top2 - 1) != top1) {
            arr[--top2] = data;
        } else {
            System.out.println("Error:Stack is full");
        }
    }

    public int pop1() {
        int a = arr[top1];
        top1--;
        return a;
    }

    public int pop2() {
        int b = arr[top2];
        top2++;
        return b;
    }

    public int peek1() {
        return arr[top1];
    }

    public int peek2() {
        return arr[top2];
    }

    public boolean isFull() {
        return (top1 == (top2 - 1));
    }

    public boolean isEmpty() {
        return (arr.length == 0);
    }

    public void display() {
        System.out.print("stack1:");
        for (int i = 0; i <= top1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.print("stack2:");
        for (int i = maxSize - 1; i >= top2; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TwoStackByOneArray tsboa = new TwoStackByOneArray(4);
        tsboa.push1(1);
        tsboa.push1(4);
        tsboa.push2(3);
        tsboa.push2(2);
        tsboa.push1(5);
        tsboa.display();
        System.out.println(tsboa.isFull());
        System.out.println(tsboa.pop1());
        System.out.println(tsboa.pop2());
        tsboa.display();

        System.out.println();
        TwoStackByOneArray ts2 = new TwoStackByOneArray(4);
        ts2.push1(1);
        ts2.push1(1);
        ts2.push1(1);
        ts2.push1(2);
        ts2.push1(1);
        ts2.display();
    }
}
