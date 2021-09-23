package com.solutions;

import javax.swing.*;
import java.util.*;

/**
 * @author ChenYu
 * @date 2021/9/23 21:42
 */
public class SolutionFortyNine {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String key = new String(cs);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> value = new ArrayList<>();
                value.add(str);
                map.put(key, value);
            }
        }
        return new ArrayList<>(map.values());
    }
}
