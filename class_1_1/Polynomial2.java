package com.dsa.mooc.class_1_1;



public class Polynomial2 {
    public static void main(String[] args) {
        //多项式最大项数
        int n = 100;
        //在x点处
        double x = 1.1;
        //多项式各项系数
        double[] a = new double[101];
        //多项式系数初始化
        init(a);

        double result1 = f1(n, a, x);
        System.out.println();
        System.out.println(result1);

        double result2 = f2(n, a, x);
        System.out.println();
        System.out.println(result2);

    }

    public static void init(double[] a) {
        for (int i = 1; i < a.length; i++) {
            if (i == 0) {
                a[i] = 0;
                continue;
            }
            a[i] = (double) 1.0 / i;
        }
    }

    public static double f1(int n, double[] a, double x) {
        double sum = a[n];
        for (int i = n; i > 0; i--) {
            sum = a[n-1] + sum * x;
            System.out.print(sum + " ");
        }
        return sum + 1;
    }

    public static double f2(int n, double[] a, double x) {
        double sum = a[0];
        for (int i = 1; i < n; i++) {
            sum += a[i] * Math.pow(x, i);
            System.out.print(sum + " ");
        }
        return sum + 1;
    }
}
