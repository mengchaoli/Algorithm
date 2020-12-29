package SlidingWindow;

public class _1423_MaximumPointsYouCanObtainfromCards {
    // Solution 1: keep a window size of n - k, sliding from left to right and calculate the sum each time, during the process, keep the minimum sum of that window.
    // At the end, use the total sum minus that minimum window sum, we can get the result.

//    public int maxScore(int[] cardPoints, int k) {
//        int windowSize = cardPoints.length - k;
//        int totalSum = 0, windowSum = 0;
//
//        for (int i = 0; i < cardPoints.length; i++) {
//            if (i < windowSize) {
//                windowSum += cardPoints[i];
//            }
//            totalSum += cardPoints[i];
//        }
//
//        int minWindowSum = windowSum;
//
//        // Sliding process
//        for (int i = 1; i <= k; i++) {
//            windowSum = windowSum + cardPoints[windowSize + i - 1] - cardPoints[i - 1];
//            minWindowSum = Math.min(minWindowSum, windowSum);
//        }
//
//        return totalSum - minWindowSum;
//    }

    // Solution 2: The result is always in continuous K elements from the begin and end of cardPoints array. eg: k = 3, pick left 3 or pick left 2 + right 1 or pick left 1 + right 2 or pick right 3
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0, max = 0;

        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }

        max = sum;

        for (int i = 1; i <= k; i++) {
            sum = sum + cardPoints[cardPoints.length - i] - cardPoints[k - i];
            max = Math.max(sum, max);
        }

        return max;
    }
}
