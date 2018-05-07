package com.dsa.mooc.class_5_4;

/**
 * 图结构一般有三种实现方式：
 * 1、边采用顺序存储结构，二维数组存储，称为图的邻接矩阵；
 * 2、边采用链表存储结构，存储行的后继，即矩阵行的单链表，称为图的邻接表；
 * 3、边采用链式存储结构，存储行和列的后继，即矩阵的十字链表，称为图的多重链表。
 * <p>
 * 下面用邻接矩阵实现一个无向无权图。
 * <p>
 * 邻接矩阵表示图的缺点：
 * 对于稀疏图，邻接矩阵占用的空间太多了，实际上只用上三角阵或下三角阵即可。
 * 所以对于系数图，用邻接表表示更省空间。
 */

public class MatrixUDG {
    private char[] mVexs;//顶点集合
    private int[][] mMatrix;//邻接矩阵

    /**
     * 创建图，用已经提供的矩阵
     *
     * @param vexs  顶点集合
     * @param egdes 边集合
     */
    public MatrixUDG(char[] vexs, char[][] egdes) {
        //顶点数和边数
        int vlen = vexs.length;
        int elen = egdes.length;

        //初始化顶点
        mVexs = new char[vlen];
        for (int i = 0; i < vlen; i++) {
            mVexs[i] = vexs[i];
        }
        //初始化邻接矩阵
        mMatrix = new int[elen][elen];
        for (int i = 0; i < elen; i++) {
            int p1 = getPosition(egdes[i][0]);
            int p2 = getPosition(egdes[i][1]);

            mMatrix[p1][p2] = 1;
            mMatrix[p2][p1] = 1;
        }
    }


    /**
     * 找到边对应的顶点在矩阵（点集）中的坐标
     *
     * @param c
     * @return
     */
    private int getPosition(char c) {
        for (int i = 0; i < mVexs.length; i++) {
            if (c == mVexs[i]) {
                return i;
            }
        }
        return -1;
    }

    public void display() {
        System.out.println("Matrix Graph:\n");
        for (int i = 0; i < mMatrix.length; i++) {
            for (int j = 0; j < mMatrix[i].length; j++) {
                System.out.printf("%2d", mMatrix[i][j]);
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
        MatrixUDG pG;
        pG = new MatrixUDG(vexs, edges);
        pG.display();
    }
}