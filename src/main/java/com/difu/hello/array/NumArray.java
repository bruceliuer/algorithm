package com.difu.hello.array;

public class NumArray {

    private int preNum[];

    //  1,2,3,4,5
    //  1,3,6,10,15
    public NumArray(int[] nums){
        preNum = new int[nums.length+1];

        for (int i = 0; i< nums.length; i++) {
            if (i == 0){
                preNum[i] = nums[i];
            } else {
                preNum[i] = preNum[i-1] + nums[i];
            }
        }
    }

    public int sumRange(int left, int right){
        if (left == 0){
            return preNum[right];
        }
        return preNum[right] - preNum[left-1];
    }
}
