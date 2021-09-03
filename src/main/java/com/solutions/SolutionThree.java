package com.solutions;

public class SolutionThree {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int[] maxLen = new int[s.length()];
        maxLen[0] = 1;
        int max = maxLen[0];
        for (int i = 1; i < s.length(); i++) {
            int count = 1;
            int step = 1;
            for (int j = i - 1; step <= maxLen[i - 1]; step++) {
                if (s.charAt(j) == s.charAt(i)) break;
                else {
                    count++;
                    j--;
                }
            }
            maxLen[i] = count;
            if (count > max) max = count;
        }
        return max;
    }
}
