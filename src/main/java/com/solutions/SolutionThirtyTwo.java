package com.solutions;

/**
 * @author ChenYu
 * @date 2021/9/16 17:03
 */
public class SolutionThirtyTwo {
    public int longestValidParentheses(String s) {
        if (s.length() == 0) {
            return 0;
        }
        //dp[i]表示以s[i]结尾的最长有效括号长度
        int[] dp = new int[s.length()];
        dp[0] = 0;
        int max = dp[0];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                dp[i] = 0;
            } else {
                if (s.charAt(i - 1) == '(') {
                    if (i >= 2) {
                        dp[i] = dp[i - 2] + 2;
                    } else {
                        dp[i] = 2;
                    }
                } else {
                    int index = i - dp[i - 1] - 1;
                    if (index >= 0 && s.charAt(index) == '(') {
                        if (index > 1) {
                            dp[i] = dp[i - 1] + dp[index - 1] + 2;
                        } else {
                            dp[i] = dp[i - 1] + 2;
                        }
                    } else {
                        dp[i] = 0;
                    }
                }
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;

    }
}
