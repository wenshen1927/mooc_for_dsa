package com.dsa.mooc.class_1_1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 数列：1，12，123，。。。1234567891011.。。
 * 求被3整除的数
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int K = sc.nextInt();
//        int[] arr = new int[K];
        int[] arr1 = { -10, 2, 2, -3, 14, -5, -23, 3, 7, -21};
//        for( int i = 0;i<K;i++){
//            arr[i] = sc.nextInt();
//        }
        int[] nums = getMaxSum(arr1);
        System.out.print(nums[0]);
        System.out.print(" ");
        System.out.print(nums[1]);
        System.out.print(" ");
        System.out.print(nums[2]);
        System.out.println();
    }

    public static int[] getMaxSum(int[] arr) {
        int thisSum = 0;
        int maxSum = 0;
        int startPos = -1;
        int endPos = -1;
        int maxLength = 0;
        int length = 0;
        int[] nums = new int[3];

        for (int i = 0; i < arr.length; i++) {
            thisSum += arr[i];
            length += 1;
            if (thisSum > maxSum) {
                maxSum = thisSum;
                endPos = i;
                maxLength = length;
            } else if (thisSum <= 0) {
                length = 0;
                thisSum = 0;
            }
        }

        if (maxSum < 0) {//处理最大和为负数的情况
            maxSum = 0;
            startPos = 0;
            endPos = arr.length - 1;
        }

        startPos = endPos - maxLength + 1;

        nums[0] = maxSum;
        nums[1] = startPos;
        nums[2] = endPos;
        return nums;
    }
}
