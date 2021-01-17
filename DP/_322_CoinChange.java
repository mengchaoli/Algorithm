package DP;

import java.util.Arrays;

public class _322_CoinChange {
    // bottom up solution, iteration
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    // top down solution, recursion
}
