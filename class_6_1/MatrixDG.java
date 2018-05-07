package com.dsa.mooc.class_6_1;

/**
 * 邻接矩阵有向图（其实和无向图差不多）
 */

public class MatrixDG {
    public char[] mVexs;//点集
    public int[][] mMatrix;//邻接矩阵

    public MatrixDG(char[] vexs, char[][] edges) {
        int vlen = vexs.length;
        int elen = edges.length;//边的个数

        //初始化点集
        mVexs = new char[vlen];
        for (int i = 0; i < vlen; i++) {
            mVexs[i] = vexs[i];
        }

        //初始化邻接矩阵
        mMatrix = new int[vlen][vlen];
        for (int i = 0; i < elen; i++) {
            int p1 = getPosition(edges[i][0]);//边的起点
            int p2 = getPosition(edges[i][1]);//边的终点

            mMatrix[p1][p2] = 1;
        }
    }

    /**
     * 获得边上的点在点集中的位置，若不存在点集，返回-1
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
        System.out.printf("Matrix Graph:\n");
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
                {'B', 'D'},
                {'C', 'D'},
                {'D', 'F'},
                {'E', 'G'},
                {'F', 'G'},
        };
        MatrixDG pG;

        pG = new MatrixDG(vexs, edges);
        pG.display();
    }
}
