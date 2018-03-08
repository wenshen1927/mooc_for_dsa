package com.dsa.mooc.class_2_1;

import org.junit.Test;

/**
 * 有序链表：链表中的数据有序
 * 相对于有序数组，有序链表插入删除速度更快，适合频繁插入删除的操作
 */

public class OrderedLinkedList {
    private Node head;
    private int size;

    private class Node {
        private int data;
        private Node next;

        public Node(int obj) {
            this.data = obj;
        }
    }

    //初始化一个空链表
    public OrderedLinkedList() {
        size = 0;
        head = null;
    }

    //插入节点，并且按照从小到大的顺序排列
    public void add(int value) {
        Node node = new Node(value);

        Node current = head;
        Node pre = null;

        //找到node的前后节点
        while (current != null && value > current.data) {
            pre = current;
            current = current.next;
        }

        if (pre == null) {//说明是一个空链表
            head = node;
            head.next = current;//是否多此一举?遍历的时候需要，每次遍历都需要把当前中间节点向后移动一格。

        } else {
            pre.next = node;
            node.next = current;
        }
    }

    //删除头结点
    public void deleteHead() {
        if (head.next == null) {
            System.out.println("空指针异常");
        }
        head = head.next;
    }

    //遍历打印
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println( );
    }

    @Test
    public void test() {
        OrderedLinkedList oll = new OrderedLinkedList();

        oll.add(3);
        oll.add(4);
        oll.add(1);
        oll.add(7);
        oll.add(11);
        oll.add(10);
        oll.display();

        oll.deleteHead();
        oll.display();
        oll.deleteHead();
        oll.display();
    }

}
