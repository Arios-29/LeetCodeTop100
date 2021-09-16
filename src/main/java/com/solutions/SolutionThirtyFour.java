package com.solutions;

/**
 * @author ChenYu
 * @date 2021/9/16 16:25
 */
public class SolutionThirtyFour {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0) {
            return new int[]{-1,-1};
        }
        int left = searchLeft(nums, target, 0, nums.length - 1);
        if (left == -1) {
            return new int[]{-1, -1};
        }
        int right = searchRight(nums, target, 0, nums.length - 1);
        return new int[]{left, right};
    }

    private int searchLeft(int[] nums, int target, int left, int right) {
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }

    private int searchRight(int[] nums, int target, int left, int right) {
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2 + (left + right) % 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if (nums[right] == target) {
            return right;
        } else {
            return -1;
        }
    }
}
