package Array;

public class _396_Rotateunction {
    public int maxRotateFunction(int[] nums) {
        int sum = 0, base = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            base += i * nums[i];
        }

        int res = base;

        for (int idx = nums.length - 1; idx >= 0; idx--) {
            base = base - nums.length * nums[idx] + sum;
            res = Math.max(res, base);
        }

        return res;
    }
}
