package com.be1ive.leetcode;

/**
 * https://oj.leetcode.com/problems/distinct-subsequences/
 */
public class DistinctSubsequences {

    //  dp[i][j] number of sequences of [T[j]..T[N]] in [S[i]..S[M]]
    //  T[N] == "" => dp[i][N] = 1
    //  S[M] == "" => dp[M][j] = 0
    //
    //  dp[i][j] = (S[i] == T[j]) ? dp[i + 1][j + 1] + dp[i + 1][j]
    //                            : dp[i + 1][j]
    public static int numDistinct(String S, String T) {

        if (S.length() >= T.length()) {
            int[] dp = new int [T.length() + 1];

            for (int i = 0; i <= S.length(); i++) {
                dp[T.length()] = 1;
            }

            for (int i = S.length() - 1; i >= 0; i--) {
                for (int j = 0; j < T.length(); j++) {
                    if (S.charAt(i) == T.charAt(j)) {
                        dp[j] += dp[j + 1];
                    }
                }
            }

            return dp[0];
        } else {
            return 0;
        }
    }
}