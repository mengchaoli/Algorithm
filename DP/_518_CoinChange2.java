package DP;

public class _518_CoinChange2 {
    public int change(int amount, int[] coins) {
        // in this dp array, index represents the amount
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = dp[i] + dp[i - coin];
            }
        }

        return dp[amount];
    }
}
