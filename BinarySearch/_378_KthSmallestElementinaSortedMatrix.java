package BinarySearch;

// important

public class _378_KthSmallestElementinaSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int lo = matrix[0][0], hi = matrix[m - 1][n - 1];

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (countSmallOrEqual(matrix, mid) < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }

    private int countSmallOrEqual(int[][] matrix, int mid) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            int j = matrix[0].length - 1;
            while (j >= 0 && matrix[i][j] > mid) {
                j--;
            }
            count += j + 1;
        }
        return count;
    }
}
