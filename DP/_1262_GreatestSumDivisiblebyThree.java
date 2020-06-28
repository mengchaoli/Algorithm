package DP;

public class _1262_GreatestSumDivisiblebyThree {
    public int maxSumDivThree(int[] nums) {
//        int[] dp = new int[]{0, Integer.MIN_VALUE, Integer.MIN_VALUE};
//
//        for (int num : nums) {
//            int[] dp2 = new int[3];
//
//            for (int i = 0; i < 3; i++) {
//                dp2[(i + num) % 3] = Math.max(dp[(i + num) % 3], dp[i] + num);
//            }
//
//            dp = dp2;
//        }
//
//        return dp[0];

        //Solution 2:
        int res = 0, leftOne = 20000, leftTwo = 20000;

        for (int num : nums) {
            res += num;

            if (num % 3 == 1) {
                leftTwo = Math.min(leftTwo, leftOne + num);
                leftOne = Math.min(leftOne, num);
            } else if (num % 3 == 2) {
                leftOne = Math.min(leftOne, leftTwo + num);
                leftTwo = Math.min(leftTwo, num);
            }
        }

        if (res % 3 == 0) return res;
        if (res % 3 == 1) return res - leftOne;
        return res - leftTwo;
    }
}
