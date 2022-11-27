package com.difu.hello.twopoint;

import java.util.Arrays;
import java.util.Collections;

/**
 * 有序数组，找出两个数之和等于目标数
 * 如：numbers=[2,7,11,15] target=11
 * 2+7=11 返回[1,2]
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,7,11,14};
        int target = 9;
        int[] result = towSum(nums, target);
        System.out.println(Arrays.toString(result));
    }

    public static int[] towSum(int[] nums, int target){
        int slow=0;
        int fast = nums.length -1;
        while (slow < fast) {
            int sum = nums[slow] + nums[fast];
            if (sum == target) {
                return new int[]{slow, fast};
            }
            // 让 sum 大一点
            if (sum < target) {
                slow ++;
            }
            // 让 sum 小一点
            if (sum > target) {
                fast --;
            }
        }

        return new int[]{-1, -1};
    }
}
