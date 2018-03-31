package com.dsa.mooc.class_3_4;

import java.util.Scanner;

/**
 * 树的同构：两棵树的根节点的两个子节点可以通过左右变换成同一颗树，这两个树就是同构的。
 * <p>
 * 1、树的表示：静态链表：数组+链表节点
 * 2、树的构建
 * 3、同构判断
 * <p>
 * 重要的知识点：
 * 1、如何构建一个树（静态链表）
 * 2、如何寻找根节点（使用一个坐标数组flag来标记出现过的子树）
 * 3、同构判别很考验逻辑。
 */

public class HomoTree {
    private static class Node {
        private Object data;
        private int leftChild;//注意这里的子节点是int类型，因为要保存子节点在数组中的位置
        private int rightChild;

        public Node(Object data) {
            this.data = data;
        }
    }


    public static Object[] buildTree(Scanner sc) {
        //存储一个Node[]数组和其root的坐标
        Object[] result = new Object[2];

        String tempLeft;
        String tempRight;
        int root = 0;
        int N = sc.nextInt();//节点的个数
        Node[] t = new Node[N];

        int[] flag = new int[N];//用来判断某个节点是不是子节点，是子节点的设为1

        for (int i = 0; i < N; i++) {//读取每一行信息

            //先把节点的信息（节点符号，左子节点，右子节点）读取出来
            Node node = new Node(sc.next());
            tempLeft = sc.next();//读入的是String类型
            tempRight = sc.next();

            //判断左子节点和右子节点的情况，如果是-，设为-1，如果有子节点，则对应为相应子节点的坐标
            //并且把出现过的子节点坐标，对应的flag数组的坐标标为1.
            if (tempLeft.equals('-')) {
                node.leftChild = -1;
            } else {
                node.leftChild = Integer.parseInt(tempLeft);
                flag[node.leftChild] = 1;
            }
            if (tempRight.equals('-')) {
                node.rightChild = -1;
            } else {
                node.rightChild = Integer.parseInt(tempRight);
                flag[node.rightChild] = 1;
            }
            //把读取到的节点放入数组中
            t[i] = node;
        }

        //寻找root点(flag == 0的点)
        for (int i = 0; i < N; i++) {
            if (flag[i] == 0) {
                root = i;
                break;
            }
        }
        //把树t和这棵树的头结点坐标root放入结果数组
        result[0] = t;
        result[1] = root;

        return result;
    }

    //写逻辑

    /**
     * 1、两个树都为空，同构；
     * 2、一个空，一个不空，不同狗；
     * 3、两个数的根节点不一样，不同狗；
     * 4、两个左子树都空，那就判断两个右子树是否同构；两个左子树不同时空（两个树的左子树都不空，或者只有一个树的左子树空）：
     * （1）如果树1.左和树2.左都空，只要比较树1.右和树2.右；
     * （2）如果树1.左和树2.左都不空，并且值相等，那么比较树1.左和树2.左 && 树1.右和树2.右；
     * （3）否则比较 树1.左和树2.右 && 树1.右和树2.左；
     */
    public static boolean isomorphism(Node[] n1, int r1, Node[] n2, int r2) {

        if (r1 == -1 && r2 == -1) {//两个树都为空
            return true;
        }
        if (r1 == -1 && r1 != -1 || r2 != -1 && r2 == -1) {//两个树中有一个树为空，另一个不空
            return false;
        }
        if (!n1[r1].equals(n2[r2])) {//两个树的头结点不一样
            return false;
        }
        //左子树为空,其子树根节点值相等，比较右子树。
        if (n1[r1].leftChild == -1 && n2[r2].leftChild == -1) {
            return isomorphism(n1, n1[r1].rightChild, n2, n2[r2].rightChild);
        }
        //左右子树都不为空，且值相等，那么比较树1.左和树2.左 && 树1.右和树2.右；
        if (n1[r1].leftChild != -1 && n2[r2].leftChild != -1 &&
                (n1[n1[r1].leftChild] == n2[n2[r2].leftChild])) {
            return (isomorphism(n1, n1[r1].leftChild, n2, n2[r2].leftChild) &&
                    isomorphism(n1, n1[r1].rightChild, n2, n2[r2].rightChild);
        } else {//比较树1.左和树2.右 && 树1.右和树2.左；左右互换
            return (isomorphism(n1, n1[r1].leftChild, n2, n2[r2].rightChild) &&
                    isomorphism(n1, n1[r1].rightChild, n2, n2[r2].leftChild);
        }


    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


    }
}






