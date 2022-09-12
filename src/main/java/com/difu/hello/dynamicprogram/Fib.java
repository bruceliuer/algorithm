package com.difu.hello.dynamicprogram;

/**
 * 普通斐波拉契数列
 * 使用递归解法
 */
public class Fib {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(fib(40));
        System.out.println("fib cost:" + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        System.out.println(dynamicFib(40));
        System.out.println("dynamic fib cost:" + (System.currentTimeMillis() - start));
    }

    public static int fib(int n){
        return n<=1 ? n : fib(n-1) + fib(n-2);
    }


    public static int dynamicFib(int n){
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        for (int i =2; i<= n; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }

    public static int dynamicFib2(int n){
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        for (int i =2; i<= n; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }
}
