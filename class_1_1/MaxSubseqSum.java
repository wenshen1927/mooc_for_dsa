package com.dsa.mooc.class_1_1;

/**
 * 求一组数的最大子列和
 * 如int[] a = {3,-2,5,6,-7,11,-2,13,-6,-4,2,5}
 * 最大子列和就是11，-2，13的和为22
 */
public class MaxSubseqSum {
    public static void main(String[] args) {
        int[] a = {3, -2, -5, 6, -7, 11, -2, 13, -6, -4, 2, 5};

        int maxSum1 = subseqSum1(a);
        System.out.println(maxSum1);

        int maxSum2 = subseqSum2(a);
        System.out.println(maxSum2);

        int maxSum4 = subseqSum4(a);
        System.out.println(maxSum4);

    }

    /**
     * 暴力枚举,复杂度O(n3)
     *
     * @param a
     * @return
     */
    public static int subseqSum1(int[] a) {
        int maxSum = 0;
        int thisSum = 0;
        //i是子列的左端，j是右端
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                thisSum = 0;//子列的和
                for (int k = i; k <= j; k++) {
                    thisSum += a[k];
//                    System.out.println(thisSum);
                    if (thisSum > maxSum) {
                        maxSum = thisSum;
                    }
                }
            }
        }
        return maxSum;
    }

    /**
     * 法2，复杂度为O(n2)
     *
     * @param a
     * @return
     */
    public static int subseqSum2(int[] a) {
        int maxSum = 0;
        int thisSum = 0;
        //i是起点j是终点
        for (int i = 0; i < a.length; i++) {
            thisSum = 0;//thisSum 是从a[i]到a[j]的子列和
            for (int j = i; j < a.length; j++) {
                thisSum += a[j];//对于相同的i，不同的j，重要在j-1次循环的基础上累加一项即可
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    /**
     * 用分治的思想将上面算法2的时间复杂度降低为O(nlogn)
     *
     * @param a
     * @return
     */
    public static int subseqSum3(int[] a) {
        return -1;
    }

    /**
     * 最快的算法：在线处理，算法复杂度降低为O(n)
     *
     * @param a
     * @return
     */
    public static int subseqSum4(int[] a) {
        int maxSum = 0;
        int thisSum = 0;
        for (int i = 0; i < a.length; i++) {
            thisSum += a[i];
            if (thisSum > maxSum) {
                maxSum = thisSum;
            } else if (thisSum < 0) {
                thisSum = 0;//如果当前的子列和为负，则不可能使后面的部分和增大，那么就抛弃子列和
            }
        }
        return maxSum;
    }
}




