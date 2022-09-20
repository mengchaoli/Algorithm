package Array;

import java.util.Arrays;

public class _764_LargestPlusSign {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] M = new int[n][n];

        for (int[] row : M) {
            Arrays.fill(row, 1);
        }
        for (int i = 0; i < mines.length; i++) {
            M[mines[i][0]][mines[i][1]] = 0;
        }

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) { // left
                if (M[i][j] != 0) {
                    count++;
                } else {
                    count = 0;
                }
                M[i][j] = count;
            }

            count = 0;
            for (int j = n - 1; j >= 0; j--) { // right
                if (M[i][j] != 0) {
                    count++;
                } else {
                    count = 0;
                }
                M[i][j] = Math.min(M[i][j], count); // because we need to find the shortest side to make it valid. we have counted other sides previously and stored the min value, so this time we just need to compare again
            }
        }

        int res = 0;

        for (int j = 0; j < n; j++) {
            int count = 0;
            for (int i = 0; i < n; i++) { // up
                if (M[i][j] != 0) {
                    count++;
                } else {
                    count = 0;
                }
                M[i][j] = Math.min(M[i][j], count);
            }

            count = 0;
            for (int i = n - 1; i >= 0; i--) { // down
                if (M[i][j] != 0) {
                    count++;
                } else {
                    count = 0;
                }
                M[i][j] = Math.min(M[i][j], count);
                res = Math.max(res, M[i][j]);
            }
        }

        return res;
    }
}
