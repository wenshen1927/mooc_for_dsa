package com.dsa.mooc.class_3_2;

/**
 * 二叉树的表示
 */
public class BinaryTree {
    public Node root;

    private class Node {
        private Object data;
        private Node leftChild;
        private Node rightChild;

        public Node(Object data) {
            this.data = data;
        }
    }

    public boolean isEmpty() {
        if (root == null) {
            return true;
        }
        return false;
    }
}
