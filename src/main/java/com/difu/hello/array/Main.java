package com.difu.hello.array;

public class Main {
    public static void main(String[] args) {
        NumArray array = new NumArray(new int[]{1,2,3,4,5});
        System.out.println(array.sumRange(0,4));

        NumArray2 array2 = new NumArray2(new int[]{1,2,3,4,5});
        System.out.println(array2.sumRange(0,4));
    }
}
