package com.solutions;

import java.util.Stack;

/**
 * @author ChenYu
 * @create 2021/9/9 17:11
 */
public class SolutionTwenty {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(' || cur == '[' || cur == '{') {
                stack.push(cur);
            } else {
                if (stack.empty()) {
                    return false;
                }
                char top = stack.pop();
                boolean coupled = (cur == ')' && top == '(') || (cur == ']' && top == '[') || (cur == '}' && top == '{');
                if (!coupled) {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
