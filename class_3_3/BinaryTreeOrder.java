package com.dsa.mooc.class_3_3;

import com.dsa.mooc.class_3_2.BinaryTree;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * 二叉树先序遍历，中序遍历，后序遍历
 */

public class BinaryTreeOrder {

    private class Node {
        private Object data;
        private Node leftChild;
        private Node rightChild;

        public Node(Object data) {
            this.data = data;
        }
    }

    //先序遍历(递归实现)（根，左，右）
    public void preOrder(Node root) {
        if (root != null) {
            //打印根节点数据
            System.out.println(root.data + " ");
            preOrder(root.leftChild);
            preOrder(root.rightChild);
        }
    }

    //中序遍历（左、根、右）
    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.leftChild);
            System.out.println(root.data + " ");
            inOrder(root.rightChild);
        }
    }

    //后序遍历（左、右、根）
    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.leftChild);
            postOrder(root.rightChild);
            System.out.println(root.data + " ");
        }
    }
}

