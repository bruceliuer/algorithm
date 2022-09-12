package com.difu.hello.countbit1;

public class CountBitOne {

    public static void main(String[] args) {
        // 15=1111 有4个1
        int count = count1(15);
        System.out.println(count);
    }

    /**
     * 计算x的二进制有多少1
     * 位运算 x=x&(x-1)
     * @param x
     * @return
     */
    public static int count1(int x){
        int count = 0;
        while (x!=0) {
            count ++;
            x = x & (x-1);
        }
        return count;
    }
}
