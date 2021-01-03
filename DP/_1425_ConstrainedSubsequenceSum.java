package DP;

import java.util.Deque;
import java.util.LinkedList;

public class _1425_ConstrainedSubsequenceSum {
    // Solution 1:
    // Time: O(nk) TLE, we need to optimize the second for loop which is for getting the max dp value in previous k numbers
//    public int constrainedSubsetSum(int[] arr, int k) {
//        int[] dp = new int[arr.length];
//        int res = Integer.MIN_VALUE;
//
//        for (int i = 0; i < arr.length; i++) {
//            int max = 0;
//
//            for (int j = Math.max(0, i - k); j < i; j++) {
//                max = Math.max(max, dp[j]);
//            }
//            dp[i] = Math.max(arr[i], arr[i] + max);
//            res = Math.max(res, dp[i]);
//        }
//
//        return res;
//    }

    // Solution 2: use Monotonic queue, this is very useful when maintaining a Monotonically increasing or decreasing sequence
    // Time: O(n)
    public int constrainedSubsetSum(int[] arr, int k) {
        // This dp array(dp[i]) is to store the biggest we can get, ending with the index of i.
        int[] dp = new int[arr.length];

        // This deque is to store the index, to maintain the monotonically increasing or decreasing sequence
        Deque<Integer> deq = new LinkedList<>();

        int res = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int max = deq.isEmpty() ? 0 : dp[deq.peekFirst()];
            dp[i] = Math.max(arr[i], arr[i] + max);
            res = Math.max(dp[i], res);

            while (!deq.isEmpty() && dp[deq.peekLast()] <= dp[i]) {
                deq.pollLast();
            }
            deq.addLast(i);

            if (!deq.isEmpty() && i - deq.peekFirst() + 1 > k) {
                deq.removeFirst();
            }
        }

        return res;
    }
}
