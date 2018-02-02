package com.dsa.mooc.class_1_1;

import java.util.Scanner;

/**
 * 方法一：循环打印1到N
 * 方法二：递归打印1到N
 * 测试这两个方法在N取不同大小的数据时的表现
 * 递归算法打印速度更快，但是打印到10000就爆栈了。
 * 所以解决问题不仅要考虑时间问题，也要考虑空间的占用。
 */

public class PrintN {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("please input N：");
        int N = sc.nextInt();

        long start1 = System.currentTimeMillis();
        print1(N);
        System.out.println();
        long end1 = System.currentTimeMillis();
        System.out.println("method1 use " + (end1 - start1) + "millis");

        PrintN p = new PrintN();
        long start2 = System.currentTimeMillis();
        p.print2(N);
        System.out.println();
        long end2 = System.currentTimeMillis();
        System.out.println("method2 use " + (end2 - start2)+"millis");
    }

    public static void print1(int n) {
        for (int i = 1; i < n; i++) {
            System.out.print(i + " ");
        }
    }

    public void print2(int n) {
        if (n>0) {
            print2(n - 1);
            System.out.print(n+" ");
        }
    }
}


