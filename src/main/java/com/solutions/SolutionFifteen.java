package com.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionFifteen {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (nums.length <= 2) return ans;
        Arrays.sort(nums);
        for (int a = 0; a < nums.length - 2; a++) {
            if (a >= 1 && nums[a] == nums[a - 1]) continue;
            int b = a + 1;
            int c = nums.length - 1;
            while (b < c) {
                if (b != a + 1 && nums[b] == nums[b - 1]) {
                    b++;
                    continue;
                }
                if (c != nums.length - 1 && nums[c] == nums[c + 1]) {
                    c--;
                    continue;
                }
                int sum = nums[a] + nums[b] + nums[c];
                if (sum < 0) {
                    b++;
                } else if (sum == 0) {
                    List<Integer> meeted = new ArrayList<Integer>();
                    meeted.add(nums[a]);
                    meeted.add(nums[b]);
                    meeted.add(nums[c]);
                    ans.add(meeted);
                    b++;
                    c--;
                } else {
                    c--;
                }
            }
        }
        return ans;
    }
}
