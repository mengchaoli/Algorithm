package BinarySearch;

import java.util.List;

public class _1428_LeftmostColumnwithatLeastaOne {
    interface BinaryMatrix {
      public int get(int row, int col);
      public List<Integer> dimensions();
    }

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int row = binaryMatrix.dimensions().get(0);
        int col = binaryMatrix.dimensions().get(1);
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < row; i++) {
            int start = 0, end = col - 1;

            while (start < end) {
                int mid = start + (end - start) / 2;
                int num = binaryMatrix.get(i, mid);

                if (num == 1) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }

            int num = binaryMatrix.get(i, start);
            if (num == 1) {
                res = Math.min(res, start);
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
