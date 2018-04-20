package com.dsa.mooc.class_5_3;

/**
 * 并查集
 */

public class UnionFind {
    Node[] nodes;
    int count;//当前存在的集合数

    private class Node {
        int data;//数据值
        int parent;//根节点值

        public Node(int data) {
            this.data = data;
        }
    }

    //初始化并查集
    public UnionFind(int[] arr) {
        nodes = new Node[arr.length];
        //初始化node,默认n个集合
        for (int i = 0; i < arr.length; i++) {
            nodes[i].data = arr[i];
            nodes[i].parent = i;
        }
    }


    //返回p所在的集合的根节点的值,若没有找到，返回-1
    public int find(int p) {
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].data == p) {
                return nodes[i].parent;
            }
        }
        return -1;
    }

    //链接a,b
    public void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (nodes[aRoot].parent < nodes[bRoot].parent) {//如果a的根节点数值（代表集合个数）比较大
            nodes[aRoot].parent += nodes[bRoot].parent;//集合b并入集合a
            nodes[bRoot].parent = nodes[aRoot].parent;
        } else {//如果集合b所在的集合比较大
            nodes[bRoot].parent += nodes[aRoot].parent;//集合a并入几个b
            nodes[aRoot].parent = nodes[bRoot].parent;
        }
        count--;//每次合并集合，集合数减一
    }

    //判断两个数是否已经联通
    public boolean connected(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) {
            return true;
        } else {
            return false;
        }
    }

    //返回目前有多少个集合
    public int count() {
        return count;
    }
}
