package com.solutions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ChenYu
 * @date 2021/9/16 22:54
 */
public class SolutionFortySix {

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numbers = new ArrayList<>();
        for (int x : nums) {
            numbers.add(x);
        }
        return permute(numbers, nums.length);
    }

    public List<List<Integer>> permute(List<Integer> nums, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        if (n == 1) {
            List<Integer> ret = new ArrayList<>();
            ret.add(nums.get(0));
            ans.add(ret);
        } else {
            List<List<Integer>> lastKind = permute(nums, n - 1);
            for (List<Integer> oneOfLastKind : lastKind) {
                for (int index = 0; index <= n - 1; index++) {
                    List<Integer> newKind = new ArrayList<>(oneOfLastKind);
                    newKind.add(index, nums.get(n - 1));
                    ans.add(newKind);
                }
            }
        }
        return ans;
    }

}
