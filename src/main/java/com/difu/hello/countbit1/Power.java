package com.difu.hello.countbit1;

public class Power {
    public static void main(String[] args) {
        System.out.println(isPower(9));
        System.out.println(isPower(8));
    }

    /**
     * 计算一个数是2的n次方
     * 2^1=10  2^2= 100 2^3=1000
     * @param x
     * @return
     */
    public static boolean isPower(int x){
        int p = x & (x-1);
        return p == 0;
    }
}
