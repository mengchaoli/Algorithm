package DP;

public class _265_PaintHouseII {
    // Original Solution
//    public int minCostII(int[][] costs) {
//        if (costs.length == 0) return 0;
//
//        int n = costs.length, k = costs[0].length;
//        int[][] memo = new int[n][k];
//
//        for (int i = 0; i < k; i++) {
//            memo[0][i] = costs[0][i];
//        }
//
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j < k; j++) {
//                memo[i][j] = findMin(memo[i - 1], j) + costs[i][j];
//            }
//        }
//
//        return findMin(memo[n - 1], memo[0].length);
//    }
//
//    private int findMin(int[] arr, int idx) {
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < idx; i++) {
//            if (arr[i] < min) {
//                min = arr[i];
//            }
//        }
//
//        for (int i = idx + 1; i < arr.length; i++) {
//            if (arr[i] < min) {
//                min = arr[i];
//            }
//        }
//
//        return min;
//    }

    // Optimized Solution
    // We only need to keep the min and secMin from last row
    // Time: O(nk)
    public int minCostII(int[][] costs) {
        if (costs.length == 0) return 0;

        int n = costs.length, k = costs[0].length;
        int preMin = 0, preMinIdx = -1, preSecMin = 0;

        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE, minIdx = -1, secMin = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                int value = costs[i][j] + (j == preMinIdx ? preSecMin : preMin);
                if (value < min) {
                    secMin = min;
                    min = value;
                    minIdx = j;
                } else if (value < secMin) {
                    secMin = value;
                }
            }
            preMin = min;
            preSecMin = secMin;
            preMinIdx = minIdx;
        }

        return preMin;
    }
}
