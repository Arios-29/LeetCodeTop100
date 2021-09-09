package com.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SolutionSeventeen {
    Map<Character, char[]> map = new HashMap<>();

    public SolutionSeventeen() {
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    public List<String> letterCombinations(String digits) {
        List<List<String>> states = new ArrayList<>(digits.length() + 1);
        states.add(0, new ArrayList<>());
        //states[index]表示等待生成的状态
        int index = 1;
        for (int i = 0; i < digits.length(); i++) {
            if(digits.charAt(i)=='1') {
                continue;
            }
            char[] tokens = map.get(digits.charAt(i));
            List<String> lastState = states.get(index - 1);
            List<String> newState = new ArrayList<>();
            if (lastState.size() == 0) {
                for (char token : tokens) {
                    newState.add(String.valueOf(token));
                }
            } else {
                for (String lastToken : lastState) {
                    for (char token : tokens) {
                        newState.add(lastToken + token);
                    }
                }
            }
            states.add(index, newState);
            index++;
        }
        return states.get(index - 1);
    }
}
