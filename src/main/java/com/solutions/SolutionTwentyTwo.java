package com.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChenYu
 * @date 2021/9/12 18:28
 */
public class SolutionTwentyTwo {
    ArrayList<String>[] cache = new ArrayList[9];

    public List<String> generate(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        ArrayList<String> answer = new ArrayList<>();
        if (n == 0) {
            answer.add("");
        }
        for (int i = 0; i < n; i++) {
            for (String left : generate(i)) {
                for (String right : generate(n - 1 - i)) {
                    answer.add("(" + left + ")" + right);
                }
            }
        }
        cache[n] = answer;
        return answer;
    }

    public List<String> generateParenthesis(int n) {
        return generate(n);
    }

}
