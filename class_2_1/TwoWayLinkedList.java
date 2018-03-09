package com.dsa.mooc.class_2_1;

import org.junit.Test;

/**
 * 双向链表:特点是每个节点都有一个前向指针和一个后向指针。可以方便地双向遍历。
 */

public class TwoWayLinkedList {

    private int size;//链表长度
    private Node head;//链表头节点
    private Node tail;//链表尾结点

    private class Node {
        private Node next;
        private Node prev;
        private Object obj;

        public Node(Object obj) {
            this.obj = obj;
        }
    }

    //初始化双向链表
    public TwoWayLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    //插入头结点
    public void addHead(Object obj) {
        Node node = new Node(obj);
        if (size == 0) {
            head = node;
            tail = node;
            size++;
        } else {//不仅要前面的节点指向下一个，下一个节点的prev也要指向上一个节点。
            head.prev = node;
            node.next = head;
            head = node;
            size++;
        }

    }

    //插入尾结点
    public void addTail(Object obj) {
        Node node = new Node(obj);
        if (size == 0) {
            head = node;
            tail = node;
            size++;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
            size++;
        }
    }

    //删除头结点
    public Node deleteHead() {
        Node temp = head;
        if (size != 0) {
            head = head.next;
            head.prev = null;
            size--;
        }
        return temp;
    }

    //删除尾结点
    public Node deleteTail() {
        Node temp = tail;
        if (size != 0) {
            tail = tail.prev;
            tail.next = null;
            size--;
        }
        return temp;

    }

    //返回节点数
    public int getSize() {
        return size;
    }

    //链表是否为空
    public boolean isEmpty() {
        return (size == 0);
    }

    //遍历打印链表
    public void display() {
        Node tempNode = head;
        if (size == 0) {
            System.out.println("[]");
        }
        while (tempNode != null) {
            System.out.print(tempNode.obj + " ");
            tempNode = tempNode.next;
        }
        System.out.println();
    }

    @Test
    public void test() {
        //增加头结点
        TwoWayLinkedList twll1 = new TwoWayLinkedList();
        twll1.addHead(1);
        twll1.addHead("e");
        twll1.addHead("r");
        twll1.addHead(4);
        twll1.display();
        //增加尾结点
        TwoWayLinkedList twll2 = new TwoWayLinkedList();
        twll2.addTail("a");
        twll2.addTail("t");
        twll2.addTail(3);
        twll2.addTail(8);
        twll2.addTail("m");
        twll2.display();
        //删除头结点，尾结点
        System.out.println(twll1.deleteHead().obj);
        System.out.println(twll1.deleteTail().obj);
        twll1.display();


    }
}
