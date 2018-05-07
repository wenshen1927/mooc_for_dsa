package com.dsa.mooc.class_6_1;


/**
 * 邻接表实现无向图
 */
public class ListUDG {
    public VNode[] mVexs; //点集

    //邻接表中代表的点
    private class VNode {
        char data;
        ENode firstNode;
    }

    //邻接表中代表边的链表的节点
    private class ENode {
        int ivex;// 该边所指向的顶点的位置
        ENode nextNode = null;
    }

    public ListUDG(char[] vexs, char[][] edgs) {
        //初始化点的数量和边的数量
        int vlen = vexs.length;
        int elen = edgs.length;

        //初始化点集合
        mVexs = new VNode[vlen];
        for (int i = 0; i < vlen; i++) {
            mVexs[i] = new VNode();
            mVexs[i].data = vexs[i];
            mVexs[i].firstNode = null;
        }

        //初始化'边'的集合
        for (int i = 0; i < elen; i++) {
            //1、读入边对应的点的字符
            char c1 = edgs[i][0];
            char c2 = edgs[i][1];

            //2、边对应的点，在点集合中的位置i1,i2
            int i1 = getPosition(c1);
            int i2 = getPosition(c2);

            //3.1、i1-->i2的边节点
            ENode node1 = new ENode();
            node1.ivex = i2;//i1指向i2

            //3.2、若i1对应的节点无后继节点，直接补上i2；若有后集结点，则把i2放在i1的链表末尾
            if (mVexs[i1].firstNode == null) {
                mVexs[i1].firstNode = node1;
            } else {
                linkLast(mVexs[i1].firstNode, node1);
            }

            //因为是无向图，所以i1-->i2和i2-->i1都要处理

            //4.1、i2-->i1的边节点
            ENode node2 = new ENode();
            node2.ivex = i1;
            //4.2、若i2对应的节点无后继节点，直接补上i1；若有后集结点，则把i1放在i2的链表末尾
            if (mVexs[i2].firstNode == null) {
                mVexs[i2].firstNode = node2;
            } else {
                linkLast(mVexs[i2].firstNode, node2);
            }
        }

    }

    /**
     * 把node链接在firstNode对应的链表的末尾
     *
     * @param firstNode
     * @param node
     */
    private void linkLast(ENode firstNode, ENode node) {
        ENode p = firstNode;
        while (p.nextNode != null) {
            p = p.nextNode;
        }
        p.nextNode = node;
    }

    private int getPosition(char c) {
        for (int i = 0; i < mVexs.length; i++) {
            if (mVexs[i].data == c) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 打印邻接表
     */
    public void print() {
        System.out.printf("List Graph:\n");
        for (int i = 0; i < mVexs.length; i++) {
            System.out.printf("%d(%c): ", i, mVexs[i].data);
            ENode node = mVexs[i].firstNode;
            while (node != null) {
                System.out.printf("%d(%c) ", node.ivex, mVexs[node.ivex].data);
                node = node.nextNode;
            }
            System.out.printf("\n");
        }
    }

    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        char[][] edges = new char[][]{
                {'A', 'C'},
                {'A', 'D'},
                {'A', 'F'},
                {'B', 'C'},
                {'C', 'D'},
                {'E', 'G'},
                {'F', 'G'}};
        ListUDG pG;

        // 自定义"图"(输入矩阵队列)
        //pG = new ListUDG();
        // 采用已有的"图"
        pG = new ListUDG(vexs, edges);

        pG.print();   // 打印图
    }

}
