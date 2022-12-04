package com.difu.hello.array;

public class NumArray2 {

    private int preNum[];

    //  1,2,3,4
    //0 1,3,6,10
    public NumArray2(int[] nums){
        preNum = new int[nums.length+1];

        for (int i = 1; i<= nums.length; i++) {
            preNum[i] = preNum[i-1] + nums[i-1];
        }
    }

    public int sumRange(int left, int right){
        return preNum[right+1] - preNum[left];
    }
}
