package DP;

public class _486_PredicttheWinner {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length, sum = 0;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
            sum += nums[i];
        }

        for (int j = 0; j < n; j++) {
            for (int i = j - 1; i>= 0; i--) {
                int a = (i + 1 < n && j - 1 >= 0) ? dp[i + 1][j - 1] : 0;
                int b = (i + 2 < n) ? dp[i + 2][j] : 0;
                int c = (j - 2 >= 0) ? dp[i][j - 2] : 0;

                dp[i][j] = Math.max(nums[i] + Math.min(a, b), nums[j] + Math.min(a, c));
            }
        }

        return dp[0][n - 1] * 2 >= sum;
    }
}
