public class _128_LongestConsecutiveSequence {
	public int minSubArrayLen(int target, int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int sum = 0, from = 0, win = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];

			while (sum >= target) {
				win = Math.min(win, i - from + 1);
				sum -= nums[from++];
			}
		}

		return win == Integer.MAX_VALUE ? 0 : win;
	}
}