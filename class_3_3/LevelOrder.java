package com.dsa.mooc.class_3_3;

import java.util.LinkedList;

/**
 * 二叉树层次遍历，每一层都是从左到右输出，借助于队列；
 * 遍历从根节点开始，首先将根节点入队，然后开始执行循环：节点出队，访问该节点，其左右儿子入队
 */

public class LevelOrder {

    private class Node {
        private Object data;
        private Node leftChild;
        private Node rightChild;

        public Node(Object data) {
            this.data = data;
        }
    }

    public void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        //创建一个队列
        LinkedList<Node> queue = new LinkedList<Node>();
        //当前节点的指针
        Node current = null;
        //首先根节点入队
        queue.add(root);
        while (!queue.isEmpty()) {
            current = queue.poll();//队列队头节点出列并访问，当前节点指向该节点
            System.out.println(current.data + " ");

            if (current.leftChild != null) {//如果当前节点的左儿子不为空，则左儿子入队
                queue.offer(current.leftChild);
            }
            if (current.rightChild != null) {//同上
                queue.offer(current.rightChild);
            }
        }
    }
}
