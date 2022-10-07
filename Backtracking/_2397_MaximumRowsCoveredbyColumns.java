package Backtracking;

public class _2397_MaximumRowsCoveredbyColumns {
    int maxRows = 0;
    public int maximumRows(int[][] matrix, int numSelect) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] placeholder = new int[n];

        backTrack(placeholder, 0, n, numSelect, matrix);

        return maxRows;
    }

    private void backTrack(int[] placeholder, int idx, int n, int left, int[][] matrix) {
        if (left == 0) {
            maxRows = Math.max(maxRows, countRows(placeholder, matrix));
            return;
        }

        for (int i = idx; i <= n - left; i++) {
            placeholder[i] = 1;
            backTrack(placeholder, i + 1, n, left - 1, matrix);
            placeholder[i] = 0;
        }
    }

    private int countRows(int[] placeholder, int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;

        for (int row = 0; row < m; row++) {
            boolean flag = true;
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 1 && placeholder[col] != 1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }

        return count;
    }
}
