package com.be1ive.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://oj.leetcode.com/problems/word-break-ii/
 */
public class WordBreak2 {

    //go bottom up checking whether new letter gives word break that exists in dictionary
    //when adding new letter we should check all possible combinations
    //
    //Ex.
    //When adding i-th letter "c" to "ode" we should check "code" + "", "co" + "de", "cod" + "e"
    //If any combination exists then d[i] = true;
    //
    public List<String> wordBreak(String s, Set<String> dict) {
        int length = s.length();

        List<String>[] dp = (List<String>[]) new List[length + 1];
        dp[length] = new ArrayList<String>() {
            {
                add("");
            }
        };

        for (int i = length - 1; i >= 0; i--) {
            for (int j = i + 1; j <= length; j++) {
                if (dict.contains(s.substring(i, j)) && dp[j] != null) {
                    if (dp[i] == null) {
                        dp[i] = new ArrayList<>();
                    }

                    for (String words : dp[j]) {
                        StringBuilder sentence = new StringBuilder(s.substring(i, j));
                        sentence.append(" ").append(words);
                        dp[i].add(sentence.toString().trim());
                    }
                }
            }
        }

        return dp[0] == null ? Collections.<String>emptyList() : dp[0];
    }

}
