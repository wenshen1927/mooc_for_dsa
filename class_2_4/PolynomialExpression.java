package com.dsa.mooc.class_2_4;


import com.dsa.mooc.class_1_1.Polynomial;
import org.junit.Test;

/**
 * 多项式求值：多项式的加法
 * 1、构造每一项的节点；构造两个多项式链表;
 * 2、分情况： 指数相同，系数相加；指数不同，copy下来；某一个链表为空，另一个链表其余的值copy下来;
 * 这里采用链表（队列）表示多项式，各节点以指数下降的顺序排列。
 * 数据结构可以使用一个有序单向链表来实现。
 */

public class PolynomialExpression {
    private PolyNode front;//头结点
    private PolyNode rear;//尾结点，可以插入节点的位置
    private int size;//节点个数

    public PolynomialExpression() {
        this.size = 0;
    }

    //多项式链表的节点
    private class PolyNode {
        private int coef;//系数
        private int expon;//指数
        private PolyNode next;

        public PolyNode() {
        }

        public PolyNode(int coef, int expon) {
            this.coef = coef;
            this.expon = expon;
        }
    }

    //给链表排序，按照指数从大到小
    private void sort() {

    }


    private void attach(PolyNode polyNode) {
        //复制一个节点，同时把next指向null
        PolyNode node = new PolyNode();
        node.expon = polyNode.expon;
        node.coef = polyNode.coef;
        node.next = null;
        if (this.size == 0) {
            this.front = node;
            this.rear = node;
            this.size++;
        } else {
            this.rear.next = node;
            this.rear = rear.next;
            this.size++;
        }
    }

    private void attach(PolyNode polyNode1, PolyNode polyNode2) {
        int coef = polyNode1.coef + polyNode2.coef;
        if (coef != 0) {//判断系数是否为0
            PolyNode node = new PolyNode();
            node.coef = coef;
            this.attach(node);
        }
    }

    /**
     * 两个多项式相加,要求两个多项式都是按照指数从大到小的顺序排列
     *
     * @param p1 第一个多项式
     * @param p2 第二个多项式
     * @return 相加后的多项式
     */
    public PolynomialExpression addPoly(PolynomialExpression p1, PolynomialExpression p2) {
        PolynomialExpression pe = new PolynomialExpression();
        int tempSize1 = p1.size;
        int tempSize2 = p2.size;
        while (tempSize1 != 0 || tempSize2 != 0) {//当两个链表都有元素的时候
            switch (Integer.compare(p1.front.expon, p2.front.expon)) {//比较两个头结点的指数项
                case 1:
                    pe.attach(p1.front);
                    p1.front = p1.front.next;
                    tempSize1--;
                    break;
                case -1:
                    pe.attach(p2.front);
                    p2.front = p2.front.next;
                    tempSize2--;
                    break;
                case 0:
                    pe.attach(p1.front, p2.front);
                    p1.front = p1.front.next;
                    p2.front = p2.front.next;
                    tempSize1--;
                    tempSize2--;
                    break;
            }
        }
        for (; tempSize1 > 0; tempSize1--) {
            pe.attach(p1.front);
            p1.front = p1.front.next;
        }
        for (; tempSize2 > 0; tempSize2--) {
            pe.attach(p2.front);
            p2.front = p2.front.next;
        }

        return pe;
    }

    public void display() {
        int tempSize = size;
        for (int i = 0; i < tempSize; i++) {
            System.out.print(front.coef + " " + front.expon + "/");
            front = front.next;
        }
        System.out.println();
    }

    @Test
    public void test() {
        PolynomialExpression poly1 = new PolynomialExpression();
        poly1.attach(new PolyNode(3, 5));
        poly1.attach(new PolyNode(4, 4));
        poly1.attach(new PolyNode(-1, 3));
        poly1.attach(new PolyNode(2, 1));
        poly1.attach(new PolyNode(-1, 0));
        poly1.display();
        System.out.println(poly1.front.coef);

        PolynomialExpression poly2 = new PolynomialExpression();
        poly2.attach((new PolyNode(2, 4)));
        poly2.attach((new PolyNode(1, 3)));
        poly2.attach((new PolyNode(-7, 2)));
        poly2.attach((new PolyNode(1, 0)));
        poly2.display();

        PolynomialExpression poly = addPoly(poly1, poly2);
        poly.display();
    }
}

