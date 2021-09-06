package com.solutions;

public class SolutionEleven {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = -1;
        int h = 0;
        int l = 0;
        while (left < right) {
            l = right - left;
            if (height[left] <= height[right]) {
                h = height[left];
                left++;
            } else {
                h = height[right];
                right--;
            }
            int s = h * l;
            if (s > max) max = s;
        }
        return max;
    }

}
