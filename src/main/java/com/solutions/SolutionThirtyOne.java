package com.solutions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ChenYu
 * @date 2021/9/14 15:49
 */
public class SolutionThirtyOne {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int flag = 0;
        for (int i = len - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                flag = i;
                break;
            }
        }
        if (flag == 0) {
            reverse(nums, 0, len - 1);
        } else {
            for (int i = len - 1; i >= flag; i--) {
                if (nums[i] > nums[flag - 1]) {
                    swap(nums, i, flag - 1);
                    break;
                }
            }
            reverse(nums, flag, len - 1);
        }
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
