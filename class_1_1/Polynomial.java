package com.dsa.mooc.class_1_1;

/**
 * 计算多项式在某点处的值:
 * 发现秦九韶算法比一般的傻瓜式算法要快一个数量级：
 * 说明解决问题的效率，跟算法的巧妙程度有关
 * 秦九韶算法的复杂度是O(N),一般算法的复杂度是O(N2)
 */

public class Polynomial {
    public static void main(String[] args) {
        //具体点
        double x = 1.1;
        //多项式最大项数
        int n = 9;
        //多项式的系数
        double[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        //多次迭代的次数
        int iter = 1000000;


        //method1
        long start1 = System.currentTimeMillis();
        double result1 = 0.0;
        for (int i = 0; i < iter; i++) {
            result1 = f1(n, a, x);
        }
        System.out.println(result1);
        long end1 = System.currentTimeMillis();
        System.out.println("method 1 use " + (end1 - start1) + "millis");

        //method2
        long start2 = System.currentTimeMillis();
        double result2 = 0.0;
        for (int i = 0; i < iter; i++) {
            result2 = f2(n, a, x);
        }
        System.out.println(result2);
        long end2 = System.currentTimeMillis();
        System.out.println("method 2 use " + (end2 - start2) + "millis");

    }

    public static double f1(int n, double[] a, double x) {
        double sum = a[0];
        for (int i = 1; i <= n; i++) {
            sum += a[i] * Math.pow(x, i);
        }
        return sum;
    }

    public static double f2(int n, double[] a, double x) {
        double sum = a[n];
        for (int i = n; i > 0; i--) {
            sum = a[i - 1] + sum * x;
        }
        return sum;
    }

    public static double getRunTime() {
        return 0.0;
    }
}
