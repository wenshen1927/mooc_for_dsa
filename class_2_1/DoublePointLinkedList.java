package com.dsa.mooc.class_2_1;

import org.junit.Test;

/**
 * 1、双端列表：依然是个单向链表，只是相对于单向列表，增加一个尾部的引用
 * 2、下面实现的实际上是一个队列。
 */


public class DoublePointLinkedList {
    //头结点
    private Node head;
    //尾节点
    private Node tail;
    //链表的长度
    private int size;

    private class Node {
        private Object data;
        private Node next;

        public Node(Object obj) {
            this.data = obj;
        }
    }

    public DoublePointLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    //链表头新增节点
    public void addHead(Object obj) {
        Node node = new Node(obj);
        if (size == 0) {//若果链表尾空，那么头结点和尾结点均为新加入的节点
            head = node;
            tail = node;

        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    //链表尾新增节点
    public void addTail(Object obj) {
        Node node = new Node(obj);
        if (size == 0) {
            head = node;
            tail = node;
            size++;
        } else {
            tail.next = node;
            tail = node;
            size++;
        }
    }

    //删除头部节点，成功返回true，失败返回false
    public boolean deleteHead() {
        if (size == 0) {//空链表
            return false;
        }
        if (head.next == null) {//若只有一个节点
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        size--;
        return true;
    }

    //删除尾部节点，成功返回true，失败返回false
    //单向链表并不能从尾部删除节点，原因是尾结点tail找不到他的上一个结点，不能往回读取结点
//    public boolean deleteTail(){
//        if (size == 0){
//            return false;
//        }
//        if ()
//    }

    //判断是否为空
    public boolean isEmpty() {
        return (size == 0);
    }

    //获取链表节点个数
    public int getSize() {
        return size;
    }

    //遍历链表,显示结点信息:单向链表，只能从一个方向遍历
    public void display() {
        Node current = head;
        int tempSize = size;
        if (size == 0) {
            System.out.println("[]");
        } else {
            while (tempSize > 0) {
                System.out.print(current.data+" ");
                current = current.next;
                tempSize--;
            }
            System.out.println();
        }
    }

    @Test
    public void test() {
        //初始化双端链表
        DoublePointLinkedList dpll = new DoublePointLinkedList();
        //添加结点
        dpll.addHead("a");
        dpll.addTail("b");
        dpll.addHead("c");
        dpll.addTail("d");
        dpll.display();//c a b d
        //删除节点
        System.out.println(dpll.deleteHead());
        dpll.display();
    }
}
