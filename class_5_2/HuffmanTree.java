package com.dsa.mooc.class_5_2;

import java.util.List;

public class HuffmanTree {
    private Node root;

    private class Node<E> {
        E data;
        int weight;
        Node left;
        Node right;

        public Node(E data, int weight) {
            this.weight = weight;
            this.left = null;
            this.right = null;
        }

        public String toString() {
            return "Node[data=" + data + ",weight=" + weight + "]";
        }
    }

    public Node createTree(List<Node> nodes) {

        while (nodes.size() > 1) {
            quickSort(nodes);//这列可以换成最小堆来排序
            //获取权值最小的两个节点
            Node left = nodes.get(nodes.size() - 1);
            Node right = nodes.get(nodes.size() - 2);

            //生成新节点，新节点的权值为两个子节点之和
            Node parent = new Node(null, left.weight + right.weight);
            parent.left = left;
            parent.right = right;

            nodes.remove(nodes.size() - 1);
            nodes.remove(nodes.size() - 2);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    private void subSort(List<Node> nodes, int start, int end) {
        if (start < end) {
            // 以第一个元素作为分界值
            Node base = nodes.get(start);
            // i从左边搜索，搜索大于分界值的元素的索引
            int i = start;
            // j从右边开始搜索，搜索小于分界值的元素的索引
            int j = end + 1;
            while (true) {
                // 找到大于分界值的元素的索引，或者i已经到了end处
                while (i < end && nodes.get(++i).weight >= base.weight)
                    ;
                // 找到小于分界值的元素的索引，或者j已经到了start处
                while (j > start && nodes.get(--j).weight <= base.weight)
                    ;

                if (i < j) {
                    swap(nodes, i, j);
                } else {
                    break;
                }
            }

            swap(nodes, start, j);

            //递归左边子序列
            subSort(nodes, start, j - 1);
            //递归右边子序列
            subSort(nodes, j + 1, end);
        }
    }

    private void swap(List<Node> nodes, int i, int j) {
        Node tmp;
        tmp = nodes.get(i);
        nodes.set(i, nodes.get(j));
        nodes.set(j, tmp);
    }

    public void quickSort(List<Node> nodes) {
        subSort(nodes, 0, nodes.size() - 1);
    }


}
