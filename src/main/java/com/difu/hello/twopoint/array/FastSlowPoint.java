package com.difu.hello.twopoint.array;

import java.util.Arrays;

/**
 * 删除有序数组中的重复项
 * 快慢指针
 */
public class FastSlowPoint {

    public static void main(String[] args) {
        // 移除数组重复的数字
        int[] arr = new int[]{0, 1, 1, 2, 2, 3, 4};
        System.out.println(removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));

        // 数组移除指定元素
        int[] arr2= new int[]{3, 2, 2, 3};
        int val = 3;
        System.out.println(removeElement(arr2, val));
        System.out.println(Arrays.toString(arr2));

        // 数组移除0，把0全放最后
        int[] arr3 = new int[]{0,1,4,0,2};
        moveZeroes(arr3);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = new int[]{1,2,3,4,5, 6, 7};
        System.out.println(binarySearch(arr4, 6));

    }


    /**
     * 0 1 1 2 2 3 4    -> 0 1 2 3 4
     *
     * 0     1      1      2      2      3       4
     * slow0  fast1
     *       slow1  fast1
     *       slow1        fast2
     *             slow2  fast2
     *             slow2          fast2
     *             slow2              fast3
     *                    slow3       fast3
     *                    slow3                 fast4
     *                            slow4         fast4
     * @param nums
     * @return
     */
    static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                // 维护 nums[0..slow] 无重复
                nums[slow] = nums[fast];
            }
            fast++;
        }
        // 数组长度为索引 + 1
        return slow + 1;
    }


    /**
     * 移除指定元素
     * nums=[3,2,2,3] val=3  -> 【2，2, 2, 3】
     *
     *   3     2     2    3
     *   slow3/fast2
     *
     *
     *
     * @param nums
     * @param val
     * @return
     */
    static int removeElement(int[] nums, int val){
        if (nums.length == 0) {
            return 0;
        }

        int slow = 0, fast = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow ++;
            }
            fast ++;
        }
        // 数组长度就是slow
        return slow;
    }


    /**
     * 比如说给你输入 nums = [0,1,4,0,2]，你的算法没有返回值，但是会把 nums 数组原地修改成 [1,4,2,0,0]
     *
     */
    static void moveZeroes(int[] nums) {
        // 去除 nums 中的所有 0，返回不含 0 的数组长度
        int p = removeElement(nums, 0);
        // 将 nums[p..] 的元素赋值为 0
        for (; p < nums.length; p++) {
            nums[p] = 0;
        }
    }


    static int binarySearch(int[] nums, int target) {
        int left=0, right= nums.length-1; int mid =0;
        while (left <= right){
             mid = (left + right) /2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        return mid;
    }
}
