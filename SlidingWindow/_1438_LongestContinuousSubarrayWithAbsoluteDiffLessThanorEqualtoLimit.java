package SlidingWindow;

import java.util.Deque;
import java.util.LinkedList;

public class _1438_LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> minDeque = new LinkedList<>();
        Deque<Integer> maxDeque = new LinkedList<>();

        int res = 1, l = 0;

        for (int r = 0; r < nums.length; r++) {
            while (!minDeque.isEmpty() && minDeque.peekLast() > nums[r]) minDeque.pollLast();
            minDeque.addLast(nums[r]);

            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[r]) maxDeque.pollLast();
            maxDeque.addLast(nums[r]);

            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if (maxDeque.peekFirst() == nums[l]) maxDeque.pollFirst();
                if (minDeque.peekFirst() == nums[l]) minDeque.pollFirst();
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
