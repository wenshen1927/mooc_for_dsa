package com.dsa.mooc.class_2_2;

import java.util.*;

public class Main {

    String num = "";

    public String getNum(int N, int[] arr) {
        int maxFirstNum = 0;
        int maxNum = 0;
        int maxIndex = -1;
        char firstNum;
        int i;
        for (i = 0; i < arr.length; i++) {
            String currentNum = arr[i] + "";
            for (int j = 0; j < currentNum.length(); j++) {
                int tempNum = Integer.parseInt(currentNum.charAt(j)+"");
                if (tempNum>maxFirstNum){
                    maxFirstNum = tempNum;
                    maxNum = arr[i];
                }
            }
            firstNum = (arr[i] + "").charAt(0);
            int firstNumInt = Integer.parseInt(firstNum + "");
            if (firstNumInt > maxFirstNum) {
                maxFirstNum = firstNumInt;
                maxNum = arr[i];
                maxIndex = i;
            }
        }
//        System.out.println();
//        System.out.println(" max num :" + maxNum);
//        System.out.println(" max index  :" + maxIndex);
//        System.out.println(" max Firstnum " + maxFirstNum);
        arr[maxIndex] = 0;
        num = num + maxNum;
//        for (int j = 0; j < arr.length; j++) {
//            System.out.print(arr[j] + " ");
//        }
        N--;
        if (N > 0) {
            getNum(N, arr);
        }
        return num;
    }

    public static void main(String[] arg) {
        Main m = new Main();
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int N = in.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = in.nextInt();
            }
            System.out.println(m.getNum(N, arr));
        }
    }
}