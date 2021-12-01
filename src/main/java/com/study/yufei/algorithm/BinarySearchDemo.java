package com.study.yufei.algorithm;

/**
 * 二分查找
 *
 * @author yufei.wang
 * @date 2021/11/11 09:56
 */
public class BinarySearchDemo {

    public static int search(int[] nums, int target) {

        int len = nums.length;
        if (len == 0) {
            return -1;
        }

        int left = 0;
        int right = len - 1;
        while (left <= right) {

            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
