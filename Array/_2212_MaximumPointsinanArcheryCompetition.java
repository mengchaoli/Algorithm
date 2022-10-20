package Array;

import java.util.Arrays;

public class _2212_MaximumPointsinanArcheryCompetition {
    int[] res = new int[12];
    int maxPoint = 0;
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        helper(numArrows, 11, aliceArrows, new int[12], 0);

        return res;
    }

    private void helper(int leftArrows, int idx, int[] aliceArrows, int[] bobArrows, int currentPoint) {
        if (leftArrows < 0) {
            bobArrows[idx] = 0;
            return;
        }

        if (idx == 0) {
            bobArrows[idx] = leftArrows;
            if (currentPoint > maxPoint) {
                maxPoint = currentPoint;
                res = Arrays.copyOf(bobArrows, 12);
            }
            return;
        }

        // bob get this point:
        bobArrows[idx] = aliceArrows[idx] + 1;
        helper(leftArrows - aliceArrows[idx] - 1, idx - 1, aliceArrows, bobArrows, currentPoint + idx);

        // bob not get this point:
        bobArrows[idx] = 0;
        helper(leftArrows, idx - 1, aliceArrows, bobArrows, currentPoint);
    }
}
