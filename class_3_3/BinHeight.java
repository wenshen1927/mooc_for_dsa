package com.dsa.mooc.class_3_3;

import org.junit.Test;

/**
 * 求二叉树的高度
 */

public class BinHeight {
    private class Node {
        private Object data;
        private Node leftChild;
        private Node rightChild;

        public Node(Object data) {
            this.data = data;
        }
    }

    public int getHeight(Node root) {
        int leftH, rightH, maxH;
        if (root != null) {
            leftH = getHeight(root.leftChild);
            rightH = getHeight(root.rightChild);
            maxH = (leftH > rightH) ? leftH : rightH;
            return (maxH + 1);
        } else return 0;
    }

}
