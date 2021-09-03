package com.solutions;

public class SolutionFour {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int amount = nums1.length + nums2.length;
        int[] nums = new int[amount];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                nums[index] = nums1[i];
                i++;
                index++;
            } else {
                nums[index] = nums2[j];
                j++;
                index++;
            }
        }
        while (i < nums1.length) {
            nums[index] = nums1[i];
            i++;
            index++;
        }
        while (j < nums2.length) {
            nums[index] = nums2[j];
            j++;
            index++;
        }
        if (amount % 2 == 1) {
            return (double) nums[amount / 2];
        } else {
            return (nums[amount / 2 - 1] + nums[amount / 2]) / 2.0;
        }
    }
}
