package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by caozhen on 2020/12/6
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class MaxSubLength {
    public static void main(String[] args) {
        maxLength("abacba");
    }

    public static int maxLength(String ss) {
        int left = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ss.length(); i++) {
            if (map.containsKey(ss.charAt(i))) {
                left = Math.max(left, map.get(ss.charAt(i)) + 1);
            }
            map.put(ss.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        System.out.println(max);
        return max;
    }
}
