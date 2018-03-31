package com.dsa.mooc.class_3_4;

import java.util.Scanner;

/**
 * 树的同构：两棵树的根节点的两个子节点可以通过左右变换成同一颗树，这两个树就是同构的。
 * <p>
 * 1、树的表示：静态链表：数组+链表
 * 2、输的构建
 * 3、同构判断
 */

public class HomoTree {
    private static class Node {
        private Object data;
        private int leftChild;
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

        int[] flag = new int[N];//用来判断某个几点是不是子节点，是子节点的设为1

        for (int i = 0; i < N; i++) {//读取每一行信息
            //先把节点的信息（节点符号，左子节点，右子节点）读取出来
            Node node = new Node(sc.next());
            tempLeft = sc.next();
            tempRight = sc.next();
            //判断左子节点和右子节点的情况，如果是-，设为-1，如果有子节点，则对应为相应子节点的坐标
            //并且
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
        result[0] = t;
        result[1] = root;

        return t;
    }

    //写逻辑
    public static boolean isomorphism(Node[] n1, int root1, Node[] n2, int root2) {
        if (root1 == -1 && root2 == -1) {//两个树都为空
            return true;
        }
        if (root1 == -1 && root1 != -1 || root2 != -1 && root2 == -1) {//两个树中有一个树为空，另一个不空
            return false;
        }
        if (!n1[root1].equals(n2[root2])) {//两个树的头结点不一样
            return false;
        }
        //先比较一侧的树
        if (n1)


    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


    }
}






