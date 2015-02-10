package com.be1ive.leetcode;

/**
 * https://oj.leetcode.com/problems/edit-distance/
 */
public class EditDistance {

    // to make word2 from word1
    //  dp[i][j] edit distance of [T[0]..T[i]] and [S[0]..S[j]]
    //  T[0] == "" => dp[0][j] = j
    //  S[0] == "" => dp[i][0] = i
    //
    //  dp[i][j] = (S[i] == T[j]) ? dp[i - 1][j - 1] - nothing
    //                            : min(dp[i - 1][j] - insert, dp[i][j - 1] - delete, dp[i - 1][j - 1] - replace)
    public int minDistance(String word1, String word2) {
        if (!word1.isEmpty() && !word2.isEmpty()) {
            int n = word1.length();
            int m = word2.length();


            int[][] dp = new int[n + 1][m + 1];

            for (int i = 1; i <= n; i++) {
                dp[i][0] = i;
            }

            for (int j = 1; j <= m; j++) {
                dp[0][j] = j;
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1] ), dp[i - 1][j - 1]) + 1;
                    }
                }
            }

            return dp[n][m];

        } else {
            return Math.max(word1.length(), word2.length());
        }
    }

}
