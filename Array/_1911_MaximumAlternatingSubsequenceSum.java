package Array;

public class _1911_MaximumAlternatingSubsequenceSum {
    public long maxAlternatingSum(int[] nums) {
        long res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            res += Math.max(nums[i] - nums[i + 1], 0);
        }

        res += nums[nums.length - 1];

        return res;
    }
}
