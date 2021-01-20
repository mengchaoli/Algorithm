package DP;

import java.util.Arrays;

public class _322_CoinChange {
    // bottom up solution, iteration
//    public int coinChange(int[] coins, int amount) {
//        int[] dp = new int[amount];
//        Arrays.fill(dp, amount + 1);
//        dp[0] = 0;
//
//        for (int i = 1; i <= amount; i++) {
//            for (int coin : coins) {
//                if (i >= coin) {
//                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
//                }
//            }
//        }
//
//        return dp[amount] == amount + 1 ? -1 : dp[amount];
//    }

    // top down solution, recursion
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }

        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int remain, int[] count) {
        if (remain < 0) {
            return -1; // invalid, and we will pass this in below's if condition in line 46
        }
        if (remain == 0) {
            return 0;
        }
        if (count[remain - 1] != 0) {
            return count[remain - 1];
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, remain - coin, count);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }

        count[remain - 1] = (min == Integer.MAX_VALUE ? -1 : min);

        return count[remain - 1];
    }
}
