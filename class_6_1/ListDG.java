package com.dsa.mooc.class_6_1;

/**
 * 邻接表实现有向图
 */
public class ListDG {

    public VNode[] mVexs;


    private class VNode {
        char data;
        ENode firstNode;
    }

    private class ENode {
        int ivex;
        ENode nextNode;
    }

    public ListDG(char[] vexs, char[][] edgs) {
        int vlen = vexs.length;
        int elen = edgs.length;

        //初始化顶点集合
        mVexs = new VNode[vlen];
        for (int i = 0; i < vlen; i++) {
            mVexs[i] = new VNode();
            mVexs[i].data = vexs[i];
            mVexs[i].firstNode = null;
        }

        //初始化边的集合
        for (int i = 0; i < elen; i++) {
            //从i1点指向i2点
            int i1 = getPosition(edgs[i][0]);
            int i2 = getPosition(edgs[i][1]);

            ENode node = new ENode();
            node.ivex = i2;
            if (mVexs[i1].firstNode == null) {
                mVexs[i1].firstNode = node;
            } else {
                linkLast(mVexs[i1].firstNode, node);
            }
        }
    }

    private void linkLast(ENode firstNode, ENode node) {
        ENode temp = firstNode;
        while (temp.nextNode != null) {
            temp = temp.nextNode;
        }
        temp.nextNode = node;
    }

    private int getPosition(char c) {
        for (int i = 0; i < mVexs.length; i++) {
            if (mVexs[i].data == c) {
                return i;
            }
        }
        return -1;
    }

    public void display() {
        System.out.printf("List Graph:\n");
        for (int i = 0; i < mVexs.length; i++) {
            System.out.printf("%d(%c):", i, mVexs[i].data);
            ENode p = mVexs[i].firstNode;
            while (p!= null) {
                System.out.printf("%d(%c):", p.ivex, mVexs[p.ivex].data);
                p = p.nextNode;
            }
            System.out.printf("\n");
        }
    }

    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        char[][] edges = new char[][]{
                {'A', 'B'},
                {'B', 'C'},
                {'B', 'E'},
                {'B', 'F'},
                {'C', 'E'},
                {'D', 'C'},
                {'E', 'B'},
                {'E', 'D'},
                {'F', 'G'}};
        ListDG pG;

        // 自定义"图"(输入矩阵队列)
        //pG = new ListDG();
        // 采用已有的"图"
        pG = new ListDG(vexs, edges);

        pG.display();   // 打印图
    }
}
