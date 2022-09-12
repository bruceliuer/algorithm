package com.difu.hello.binarysearch;

public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        int target = 8;
        System.out.println(binarySearch(nums, target));
    }

    /**
     * 二分
     * 0 1 2 3 4 5 6 7   target 7
     * 1. left = 0, right= 7, mid= left + (right-left)/2=3
     * 2. left = 4, right= 7, mid= left + (right-left)/2=5
     * 3. left = 6, right= 7, mid= left + (right-left)/2=6
     * 4. left = 7, right= 7,
     * @param nums
     * @param taget
     * @return
     */
    static int binarySearch(int[] nums, int taget){
        int left = 0;
        int right = nums.length-1;

        while (left <= right) {
            int mid = left + (right-left)/2;
            if (taget == nums[mid]) {
                return mid;
            } else if (taget < nums[mid]) {
                right = mid -1;
            } else {
                left = mid +1;
            }
        }
        return -1;
    }
}
