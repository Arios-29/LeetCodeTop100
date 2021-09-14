package com.solutions;

/**
 * @author ChenYu
 * @date 2021/9/14 16:43
 */
public class SolutionThirtyThree {
    private int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (target == nums[mid]) {
            return mid;
        } else if (target < nums[mid]) {
            return binarySearch(nums, left, mid - 1, target);
        } else {
            return binarySearch(nums, mid + 1, right, target);
        }

    }

    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (target < nums[i + 1] || target > nums[i]) {
                    return -1;
                }
                if (target <= nums[nums.length - 1]) {
                    return binarySearch(nums, i + 1, nums.length - 1, target);
                }
                if (target >= nums[0]) {
                    return binarySearch(nums, 0, i, target);
                }
            }
        }
        return binarySearch(nums, 0, nums.length - 1, target);
    }
}
