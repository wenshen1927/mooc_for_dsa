package com.dsa.mooc.class_9_1;

public class PrintUtil {
    public static void print(int[] arr) {
        for (int i :
                arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void print(char[] arr) {
        for (char i :
                arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void print(char[][] arr) {
        for (char[] i :
                arr) {
            for (char j :
                    i) {
                System.out.print(j + " ");
            }

        }
        System.out.println();
    }

    public static void print(int[][] arr) {
        for (int[] i :
                arr) {
            System.out.println(i);
            for (int j :
                    i) {
                System.out.print(j + " ");
            }

        }
        System.out.println();
    }
}
