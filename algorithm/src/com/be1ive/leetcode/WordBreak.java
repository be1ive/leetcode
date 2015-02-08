package com.be1ive.leetcode;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * https://oj.leetcode.com/problems/word-break/
 */
public class WordBreak {

    public boolean wordBreak(String s, Set<String> dict) {
        int length = s.length();

        boolean[] dp = new boolean[length + 1];
        dp[length] = true;

        for (int i = length - 1; i >= 0; i--) {
            for (int j = i + 1; j <= length; j++) {
                if (dict.contains(s.substring(i, j)) && dp [j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }
}
