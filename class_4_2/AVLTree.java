package com.dsa.mooc.class_4_2;

/**
 * 二叉搜索树插入节点的次序不同，会导致树的深度不同，进而导致查找效率不同（平均查找长度ASL）。
 * 平衡二叉树(AVL树)：左右两个子树的高度差不多，或者节点数差不多
 * 平衡因子BF：BF（T）= hL - hR
 * AVL树：任意节点左右子树高度差绝对值不大于1，平衡引子绝对值小于1，
 * 平衡二叉树依然是二叉搜索树，依然要符合搜索树的条件。
 */

public class AVLTree {
    private Node root;//根节点

    //AVL树节点
    private class Node {
        private int data;
        private Node leftChild;
        private Node rightChild;
        private int height;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * 获取树的高度:认为空二叉树的高度是0，有一个根节点高度是1
     */
    public int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        return root.height;
    }

    /**
     * 比较大小
     */
    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    /**
     * LL旋转(画图易懂)
     * k2是发现者节点，k1是k2的左子节点，麻烦者是k1的左子节点，所以是LL旋转
     * <p>
     * 返回值：旋转之后的新的根节点
     */
    private Node leftLeftRotation(Node k2) {
        Node k1;

        k1 = k2.leftChild;//先给k1赋值,再把k1变成根节点
        k2.leftChild = k1.rightChild;
        k1.rightChild = k2;

        //更新k1,k2的高度
        //当前节点要比左右子节点的高度都要高1
        k2.height = max(getHeight(k2.leftChild), getHeight(k2.rightChild)) + 1;
        k1.height = max(getHeight(k1.leftChild), getHeight(k1.rightChild)) + 1;

        return k1;
    }

    /**
     * RR旋转
     */
    private Node rightRightRotation(Node k1) {
        Node k2;

        k2 = k1.rightChild;
        k1.rightChild = k2.leftChild;
        k2.leftChild = k1;

        k1.height = max(getHeight(k1.leftChild), getHeight(k1.rightChild)) + 1;
        k2.height = max(getHeight(k2.leftChild), getHeight(k2.rightChild)) + 1;

        return k2;
    }

    /**
     * LR旋转：分成两步，先对（从上到下）第一个发现者的左子节点做右右旋转，在对第一个发现者做左左旋转
     */
    private Node leftRightRotation(Node k3) {
        k3.leftChild = rightRightRotation(k3.leftChild);

        return leftLeftRotation(k3);
    }

    /**
     * RL旋转：先左左旋转，再右右旋转
     */
    private Node rightLeftRotation(Node k3) {
        k3.rightChild = leftRightRotation(k3.rightChild);

        return rightRightRotation(k3);
    }

    /**
     * 插入节点，并返回根节点
     *
     * @param root ： 树的根节点
     * @param key  ： 插入的数据
     * @return
     */
    public Node insert(Node root, int key) {
        if (root == null) {//若树为空，新建一个节点
            root = new Node(key);
        } else {
            if (key < root.data) {//如果插入的节点比根节点小，则想左子树插入
                root.leftChild = insert(root.leftChild, key);
                //检查树是否平衡
                if ((getHeight(root.leftChild) - getHeight(root.rightChild)) == 2) {
                    if (key < root.leftChild.data) {//若插入左节点下面，则对根节点做左左旋转
                        root = leftLeftRotation(root);
                    } else {//若插入左子节点的右边，则对根节点做左右旋转
                        root = leftRightRotation(root);
                    }
                }
            } else if (key > root.data) {//如果插入的节点比根节点大，则向右子树插入
                root.rightChild = insert(root.rightChild, key);
                if (getHeight(root.rightChild) - getHeight(root.leftChild) == 2) {
                    if (key < root.rightChild.data) {
                        root = rightLeftRotation(root);
                    } else {
                        root = rightRightRotation(root);
                    }
                }
            } else {//key == root.data
                System.out.println("添加失败，不允许添加相同的节点！");
            }
        }

        root.height = max(getHeight(root.leftChild), getHeight(root.rightChild));

        return root;
    }

    //删除节点
}

