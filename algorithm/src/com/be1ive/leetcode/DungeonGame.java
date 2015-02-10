package com.be1ive.leetcode;

/**
 * https://oj.leetcode.com/problems/dungeon-game/
 */
public class DungeonGame {

    //dp[0][i] - min path hp
    //dp[1][i] - maximum current hp
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;

        int[][] dp = new int[2][m];

        dp[1][0] = dungeon[0][0];
        dp[0][0] = Math.max(1 - dungeon[0][0], 1);
        for (int i = 1; i < m; i++) {
            dp[1][i] = dp[1][i - 1] + dungeon[0][i];
            dp[0][i] = Math.max(1 - dp[1][i], dp[0][i - 1]);
        }

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {

                if (i - 1 >= 0) {
                    dp[0][i] = Math.min(Math.max(dp[0][i], 1 - dp[1][i] - dungeon[j][i]),
                                        Math.max(dp[0][i - 1], 1 - dp[1][i - 1] - dungeon[j][i]));

                    dp[1][i] = Math.max(dp[1][i], dp[1][i - 1])  + dungeon[j][i];

                } else {
                    dp[1][i] = dp[1][i] + dungeon[j][i];
                    dp[0][i] = Math.max(1 - dp[1][i], dp[0][i]);
                }
            }
        }

        return dp[0][m - 1];
    }
}
