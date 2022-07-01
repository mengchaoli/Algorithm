package Array;

import java.util.Stack;

/**
 * TAG: Array, Stack
 * Time: O(n)
 * Space: O(k)
 **/

public class _1673_FindtheMostCompetitiveSubsequence {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (stack.size() != 0 && nums[stack.peek()] > nums[i] && stack.size() + nums.length - i > k) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(i);
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = nums[stack.pop()];
        }

        return result;
    }
}
