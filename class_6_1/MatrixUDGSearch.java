package com.dsa.mooc.class_6_1;

/**
 * 邻接矩阵实现的无向图，并实现深度优先遍历（DFS）和宽度优先遍历（BFS）
 */
public class MatrixUDGSearch {
    private char[] mVertex;
    private int[][] mMatrix;

    public MatrixUDGSearch(char[] vertex, char[][] edges) {
        int vlen = vertex.length;
        int elen = edges.length;

        mVertex = new char[vlen];
        for (int i = 0; i < vlen; i++) {
            mVertex[i] = vertex[i];
        }

        mMatrix = new int[vlen][vlen];
        for (int i = 0; i < elen; i++) {
            int p1 = getPosition(edges[i][0]);
            int p2 = getPosition(edges[i][1]);

            mMatrix[p1][p2] = 1;
            mMatrix[p2][p1] = 1;
        }
    }

    private int getPosition(char c) {
        for (int i = 0; i < mVertex.length; i++) {
            if (mVertex[i] == c) {
                return i;
            }
        }
        return -1;
    }

    //无向图邻接矩阵实现方法的深度优先遍历
    public void DFS(int i, boolean[] visited) {
        //第i个节点被访问到了
        visited[i] = true;
        System.out.printf("%c", mVertex[i]);

        for (int j = 0; j < mMatrix[i].length; j++) {
            if (mMatrix[i][j] == 1 && !visited[j]) {
                DFS(j, visited);
            }
        }

    }

    public void DFS() {
        //初始化所有节点都没有被访问过
        boolean[] visited = new boolean[mVertex.length];
        for (int i = 0; i < mVertex.length; i++) {
            visited[i] = false;
        }

        System.out.println("DFS:");
        for (int i = 0; i < mVertex.length; i++) {
            if (!visited[i]) {
                DFS(i, visited);
            }
        }
        System.out.printf("\n");

    }

    //无向图邻接矩阵实现方法的宽度优先遍历
    public void BFS() {

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

    public void DFS1() {
        boolean[] visited = new boolean[mVertex.length];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
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
        MatrixUDGSearch pG;

        // 自定义"图"(输入矩阵队列)
        //pG = new MatrixUDG();
        // 采用已有的"图"
        pG = new MatrixUDGSearch(vexs, edges);

        pG.display();   // 打印图
        pG.DFS();     // 深度优先遍历
//        pG.BFS();     // 广度优先遍历    }
    }
}
