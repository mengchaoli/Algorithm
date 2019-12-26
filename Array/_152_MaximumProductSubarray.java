package Array;

public class _152_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int max = nums[0], currMax = nums[0], currMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = currMin;
                currMin = currMax;
                currMax = temp;
            }

            currMax = Math.max(nums[i], nums[i] * currMax);
            currMin = Math.min(nums[i], nums[i] * currMin);

            max = Math.max(max, currMax);
        }
        return max;
    }
}
