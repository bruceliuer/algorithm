package com.difu.hello.no1;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        int[] nums = {7,11,15,2};
        int target = 13;
        int[] result = twoSum2(nums, target);
        System.out.printf(Arrays.toString(result));

    }

    //int[] nums = {7,11,15,2};
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            int tmp = target - nums[i];
            if (hashtable.containsKey(tmp)) {
                return new int[]{ hashtable.get(tmp), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }


}