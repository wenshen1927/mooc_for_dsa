package com.dsa.mooc.class_4_1;

import com.dsa.mooc.class_3_2.BinaryTree;

/**
 * 二叉搜索树（二叉排序树）
 * 回想二分查找的时候，我们输入的数组是有序的，这就使二分查找具有了很好的查询效率。
 * 二叉树在非空的时候，根节点大于左子节点的值，根节点大于右子节点的值,左右子树都是二叉搜索树。这就是二叉搜索树。
 */

public class BinSearchTree {
    private Node root;//当前树的根节点

    private class Node {
        public int data;
        private Node leftChild;
        private Node rightChild;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * 输入是一个二叉搜索树和待搜索的key(递归的方法）
     * 这里使用的是尾递归：尾调用是指一个函数里的最后一个动作是一个函数调用的情形，最后调用的函数是自身就是尾递归：
     * 即这个调用的返回值直接被当前函数返回的情形，形式上只要是最后一个return语句返回的是一个完整函数，它就是尾递归。。
     * <p>
     * <p>
     * 查找的效率取决于树的高度
     *
     * @param root
     * @param key
     * @return
     */
    public Node find1(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.data) {
            return find1(root.leftChild, key);//尾递归，比较节省内存空间
        } else if (key > root.data) {
            return find1(root.rightChild, key);
        }
        return root;
    }

    /**
     * 非递归形式
     */
    public Node find2(Node root, int key) {
        Node current = root;
        while (current != null) {
            if (key < current.data) {
                current = current.leftChild;
            } else if (key > current.data) {
                current = current.rightChild;
            } else {
                return current;
            }
        }
        return null;//遍历完整个树没找到，返回Null
    }

    //findMin:一直向左搜索，直到最左边的子节点（用非递归地方式）
    public Node findMin(Node root) {
        Node current = root;//指向当前节点
        Node parent = null;//维护一个父节点
        while (current != null) {
            parent = current;
            current = current.leftChild;
        }
        //当循环结束的时候，current指向叶节点的子节点（null），此时parent也就是叶节点，返回parent
        return parent;
    }

    //findMax：一直向右搜索，直到最右边的子节点（用递归的方式）
    public Node findMax(Node root) {
        if (root == null) {//空二叉树，返回null
            return null;
        }
        if (root.rightChild == null) {//找到叶子节点，返回
            return root;
        }
        return findMax(root.rightChild);

    }

    //insert:插入
    public boolean insert(int data) {
        Node node = new Node(data);
        if (root == null) {//树为空，直接挂在根节点上
            root = node;
            return true;
        }
        Node current = root;//指向当前节点
        Node parentNode = null;//维护一个父节点,注意保存父节点的信息
        while (current != null) {
            parentNode = current;
            if (data < current.data) {//如果data比当前节点的值小，则向左搜索
                current = current.leftChild;
                if (current == null) {//若左子节点是空，则把节点挂在左子节点上
                    parentNode.leftChild = node;
                    return true;
                }
            } else if (data > current.data) {
                current = current.rightChild;
                if (current == null) {
                    parentNode.rightChild = node;
                    return true;
                }
            }
        }
        return false;
    }

    //delete：删除，分三种情况：没有叶节点，有一个叶节点，有两个叶节点
    //太复杂，有时间在写
    // TODO: 2018/4/2  
    public boolean delete(int data) {

        return false;
    }

    public static void main(String[] args) {
        BinSearchTree bst = new BinSearchTree();
        bst.insert(20);
        bst.insert(30);
        bst.insert(40);
        bst.insert(50);
        bst.insert(10);
        bst.insert(12);
        bst.insert(9);
        bst.insert(16);

        System.out.println(bst.findMax(bst.root).data);
        System.out.println(bst.findMin(bst.root).data);
    }
}
