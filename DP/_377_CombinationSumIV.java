package DP;

import java.util.Arrays;

public class _377_CombinationSumIV {
    // solution 1: TLE
//    public int combinationSum4(int[] nums, int target) {
//        if (target == 0) {
//            return 1;
//        }
//
//        int res = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            if (target >= nums[i]) {
//                res += combinationSum4(nums, target - nums[i]);
//            }
//        }
//
//        return res;
//    }

    // solution 2: DP
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, target, dp);
    }

    private int helper(int[] nums, int target, int[] dp) {
        if (target < 0) {
            return 0;
        } else if (dp[target] != -1) {
            return dp[target];
        } else if (target == 0) {
            return 1;
        }

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            count += helper(nums, target - nums[i], dp);
            // important:
            dp[target] = count;
        }

        return count;
    }
}
