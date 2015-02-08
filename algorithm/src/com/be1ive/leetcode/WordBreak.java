package com.be1ive.leetcode;

import java.util.Set;

/**
 * https://oj.leetcode.com/problems/word-break/
 */
public class WordBreak {

    //go bottom up checking whether new letter gives word break that exists in dictionary
    //when adding new letter we should check all possible combinations
    //
    //Ex.
    //When adding i-th letter "c" to "ode" we should check "code" + "", "co" + "de", "cod" + "e"
    //If any combination exists then d[i] = true;
    //
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
