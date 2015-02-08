package com.be1ive.leetcode;

/**
 * https://oj.leetcode.com/problems/decode-ways/
 */
public class DecodeWays {

    public static int numDecodings(String s) {
        if (!s.isEmpty()) {
            int[] dp = new int[s.length()];

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) > '0') {
                     dp[i] += ((i - 1 >= 0) ? dp[i - 1] : 1);
                }
                if ((i - 1 >= 0) && (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6'))) {
                    dp[i] += ((i - 2 >= 0) ? dp[i - 2] : 1);
                }
            }

            return dp[s.length() - 1];
        } else {
            return 0;
        }
    }
}
