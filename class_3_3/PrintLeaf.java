package com.dsa.mooc.class_3_3;

import java.util.Stack;

/**
 * 打印二叉树叶子节点
 */
public class PrintLeaf {

    private class Node {
        private Object data;
        private Node leftChild;
        private Node rightChild;

        public Node(Object data) {
            this.data = data;
        }
    }

    public void printLeaf(Node root) {
        if (root != null) {
            //若节点的左子树和右子树都没有，则当前节点就是叶子节点
            if (root.leftChild == null && root.rightChild == null) {
                System.out.println(root.data + " ");
            }
            printLeaf(root.leftChild);
            printLeaf(root.rightChild);
        }
    }

    //非递归方式
    public void printLeaf1(Node root) {
        Stack<Node> stack = new Stack();
        Node cur = root;
        while (!stack.isEmpty() || cur != null) {

            while (cur != null) {
                stack.push(cur);
                cur = cur.leftChild;
            }
            if (!stack.isEmpty()) {
                cur = stack.pop();
                if (cur.leftChild == null && cur.rightChild == null) {
                    System.out.println(cur.data + " ");
                }
                cur = cur.rightChild;
            }
        }
    }
}
