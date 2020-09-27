package DP;

// this question is similar with https://www.geeksforgeeks.org/minimum-sum-path-triangle/
public class _256_PaintHouse {
    public int minCost(int[][] costs) {
        // Original solution

//        if (costs.length == 0) {
//            return 0;
//        }
//        int[][] memo = new int[costs.length][3];
//
//        for (int i = 0; i < 3; i++) {
//            memo[0][i] = costs[0][i];
//        }
//
//        for (int i = 1; i < costs.length; i++) {
//            memo[i][0] = Math.min(memo[i - 1][1], memo[i - 1][2]) + costs[i][0];
//            memo[i][1] = Math.min(memo[i - 1][0], memo[i - 1][2]) + costs[i][1];
//            memo[i][2] = Math.min(memo[i - 1][0], memo[i - 1][1]) + costs[i][2];
//        }
//
//        return Math.min(Math.min(memo[costs.length - 1][0], memo[costs.length - 1][1]), memo[costs.length - 1][2]);

        // Optimized Solution: since we only need the previous one's status, so we can use variable to store and save spaces
        if (costs.length == 0) {
            return 0;
        }

        int[] memo = new int[3];

        for (int i = 0; i < 3; i++) {
            memo[i] = costs[0][i];
        }

        for (int i = 1; i < costs.length; i++) {
            // store the value before we change it, tempR means tempRED
            int tempR = memo[0];
            memo[0] = Math.min(memo[1], memo[2]) + costs[i][0];
            // tempB means tempBLUE
            int tempB = memo[1];
            memo[1] = Math.min(tempR, memo[3]) + costs[i][1];
            memo[2] = Math.min(tempR, tempB) + costs[i][2];
        }

        return Math.min(Math.min(memo[0], memo[1]), memo[2]);
    }
}
