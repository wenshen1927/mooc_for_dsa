package com.dsa.mooc.class_2_2;

import org.junit.Test;

/**
 * 链表实现堆栈
 */

public class StackByLinkedList {
    private int size;
    private Node top;

    //初始化堆栈，相对于数组，链表不需要指定栈的大小
    public StackByLinkedList() {
        size = 0;
        top = null;
    }

    private class Node {
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }
    }

    public void push(Object data) {
        Node newNode = new Node(data);
        if (size == 0) {
            top = newNode;
            size++;
        } else {
            newNode.next = top;
            top = newNode;
            size++;
        }
    }

    public Object pop() {
        Object tempTop;
        if (size == 0) {
            return null;
        } else {
            tempTop = top.data;
            top = top.next;
            size--;
        }
        return tempTop;
    }

    //访问栈顶
    public Object peek() {
        return top.data;
    }

    //是否空栈
    public boolean isEmpty() {
        return (size == 0);
    }

    //是否满栈: 用链表实现不存在这个问题，用链表实现的栈可以随意扩充栈的大小
//    public boolean isFull() {
//
//    }

    public void display() {
        Node node = top;
        int tempSize = size;
        if (size == 0) {
            System.out.println("[]");
        }
        while (tempSize > 0) {
            System.out.print(node.data + " ");
            node = node.next;
            tempSize--;
        }
        System.out.println();
    }

    @Test
    public void test() {
        StackByLinkedList stack = new StackByLinkedList();
        stack.push("a");
        stack.push("e");
        stack.push("d");
        stack.push("f");
        stack.display();

        stack.pop();
        stack.display();

        System.out.println(stack.peek());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.isEmpty());
    }
}
