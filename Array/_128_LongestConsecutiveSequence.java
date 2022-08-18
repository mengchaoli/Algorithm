public class _128_LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		Set<Integer> set = new HashSet<>();
		int maxLen = 1;

		for (int num : nums) {
			set.add(num);
		}

		for (int num: nums) {
			int count = 1;
			int val = num;

			while (set.remove(--val)) {
				count++;
			}

			// reset val
			val = num;
			while (set.remove(++val)) {
				count++;
			}

			maxLen = Math.max(maxLen, count);
		}

		return maxLen;
	}
}