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
        boolean root = true;//默认都是根节点

        public Node(int data) {
            this.data = data;
        }
    }

    //初始化并查集
    public UnionFind(int[] arr) {
        nodes = new Node[arr.length];
        //初始化node,默认n个集合
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new Node(arr[i]);
            nodes[i].parent = i;//初始化，每个节点的父节点都是自己
        }
        count = arr.length;
    }


    //返回p所在的集合的根节点的值,若没有找到，返回-1
    public int find(int p) {
        Node node = new Node(p);
        int index = -1;
        for (int i = 0; i < nodes.length; i++) {//检查p在不在集合中
            if (nodes[i].data == node.data) {
                index = i;
                break;
            }
        }
        if (index == -1) {//若值p不在集合中，就返回-1
            return index;
        }
        //值p在集合中，返回它的根节点
        while (!nodes[index].root) {
            find(nodes[index].parent);
        }
        return nodes[index].parent;
    }

    //链接a,b，把节点少的树并入节点多的树，减少树的高度
    public void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        System.out.println("aRoot:" + aRoot + " bRoot" + bRoot);
        if (aRoot > 0 && bRoot > 0) {
            //假设刚开始的时候，每个节点都是一个集合，那就要单读处理
            nodes[bRoot].parent = aRoot;
            nodes[aRoot].parent = -2;
        } else {
            if (nodes[aRoot].parent < nodes[bRoot].parent) {//如果a的根节点数值（代表集合个数）比较大，注：根节点的数值都是负数
                nodes[aRoot].parent += nodes[bRoot].parent;//集合b并入集合a
                nodes[bRoot].parent = aRoot;
            } else {//如果集合b所在的集合比较大（或者相等）
                nodes[bRoot].parent += nodes[aRoot].parent;//集合a并入几个b
                nodes[aRoot].parent = bRoot;
            }
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

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        UnionFind un = new UnionFind(arr);
        un.union(3, 6);
        System.out.println("count : " + un.count());
        System.out.println(un.find(6));
    }
}
