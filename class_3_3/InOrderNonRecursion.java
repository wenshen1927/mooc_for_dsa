package com.dsa.mooc.class_3_3;

import java.util.Stack;

/**
 * 非递归地实现中序遍历：
 * 1、遇到一个结点，就把他压栈，并去遍历他的左子树；
 * 2、当左子树便利结束后，从栈顶弹出这个结点并访问他；
 * 3、然后按其右指针在去中序遍历该结点的右子树。
 * 其实，中序遍历和前序遍历的路径是一样的，只是打印顺序不同。
 *
 *
 */
public class InOrderNonRecursion {
    private class Node {
        private Object data;
        private Node leftNode;
        private Node rightNode;

        public Node(Object data) {
            this.data = data;
        }
    }


    public void inOrder(Node root) {
        Stack stack = new Stack();//初始化栈
        Node bt = root;
        while (bt != null || !stack.isEmpty()) {
            while (bt != null) {//一直向左遍历树，并且将经过的结点都压栈
                stack.push(bt);
                bt = bt.leftNode;
            }
            if (!stack.isEmpty()) {
                bt = (Node) stack.pop();//结点出栈
                System.out.println(bt.data);//访问结点
                bt = bt.rightNode;//转向右子树
            }
        }
    }

    public void preOrder(Node root) {
        Stack stack = new Stack();
        Node tempNode = root;
        while (tempNode != null || !stack.isEmpty()) {
            while (tempNode != null) {
                stack.push(tempNode);
                System.out.println(tempNode.data);
                tempNode = tempNode.leftNode;
            }
            if (!stack.isEmpty()) {
                tempNode = (Node) stack.pop();
                tempNode = tempNode.rightNode;
            }
        }
    }

    /**
     * 后序遍历
     * @param root
     */
    public void postOrder(Node root){
        Stack stack = new Stack();

    }
}
