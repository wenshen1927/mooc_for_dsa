package com.dsa.mooc.class_2_1;

import org.junit.Test;

/**
 * 1、链表（Linked list）是一种常见的基础数据结构，是一种线性表，
 * 但是并不会按线性的顺序存储数据，而是在每一个节点里存到下一个节点的指针(Pointer)。也就是说，节点之间是逻辑相连，物理不相连。
 * 2、链表可以随时扩充，可以充分利用内存空间，但是读取速度慢（查找慢），插入快，删除快。但是增加了节点的指针域，所以空间开销大。
 * 3、下面实现的实际上是一个栈。
 * 4、单向链表不能在链表中间插入节点。
 */


public class SingleLinkedList {
    //链表节点的个数
    private int size;
    //这是一个带头结点的链表，头结点一般不包含data,但是他的next指向第一个节点（首元节点）。
    // 有的头结点也有data,存放链表的长度等。
    private Node head;


    //默认初始化链表
    public SingleLinkedList() {
        size = 0;
        head = null;
    }

    //节点类
    private class Node {
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }
    }

    //在链表头添加元素
    public Object addHead(Object obj) {
        //首先创建一个节点
        Node newHead = new Node(obj);
        if (size == 0) {//若链表为空，那新加入的节点就是头结点
            head = newHead;
        } else {//链表非空，新节点的next指向头结点，然后更新头结点。
            newHead.next = head;
            head = newHead;
        }
        size++;
        return obj;

    }

    //在链表头删除元素
    public boolean removeHead() {
        if (size == 0) {
            return false;
        }
        head = head.next;
        size--;
        return true;
    }

    //查找指定元素，找到了返回节点Node,找不到返回null
    public Node find(Object obj) {
        Node current = head;
        int tempSize = size;
        //遍历，找到指定元素
        while (tempSize > 0) {
            if (current.data.equals(obj)) {
                return current;
            } else {
                current = current.next;
                tempSize--;
            }
        }
        return null;
    }

    //删除指定元素，删除成功返回true
    public boolean delete(Object obj) {
        if (size == 0) {
            return false;
        }
        //需要找到待删除节点的前后节点
        Node current = head;
        Node previous = head;

        //遍历，找到目标元素的前后节点
        while (!current.data.equals(obj)) {
            if (current.next == null) {
                return false;
            }
            previous = current;
            current = current.next;
        }
        //如果删除的是头结点，那么previous就没有用了
        if (current == head) {
            head = current.next;
        } else {//删除的不是第一个节点
            previous.next = current.next;
        }
        size--;
        return true;
    }

    //判断链表是否为空
    public boolean isEmpty() {
//        if (size == 0) {
//            return true;
//        }
//        return false;

        return (size == 0);
    }

    //显示节点信息（遍历链表）
    public void display() {
       if (size <= 0){//空表，输出空
           System.out.println("[]");
       }else {//线性表非空，则从head开始遍历
           Node current = head;
           int tempSize = size;
           while (tempSize > 0){
               System.out.print(current.data+" ");
               current = current.next;
               tempSize--;
           }
           System.out.println();
       }
    }

    @Test
    public void testSingleLinkedList() {
        //初始化单向链表
        SingleLinkedList list = new SingleLinkedList();
        //向单向链表中添加元素
        list.addHead('a');
        list.addHead('b');
        list.addHead('c');
//        System.out.println(list.removeHead());
        //遍历单向链表
        list.display();
        //移除单向链表头元素
        System.out.println(list.removeHead());
        list.display();
        //删除指定元素
        System.out.println(list.delete('a'));
        list.display();
        //判断链表是否为空
        System.out.println("isEmpty:"+list.isEmpty());
        //查找指定元素
        System.out.println("find : b -->"+list.find('b').data);

        System.out.println(list);
    }

}



