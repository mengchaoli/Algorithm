package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _436_FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        int[] head = new int[intervals.length];
        Map<Integer, Integer> indices = new HashMap<>();

        for (int i = 0; i < intervals.length; i++) {
            head[i] = intervals[i][0];
            indices.put(intervals[i][0], i);
        }

        Arrays.sort(head);

        int[] res = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            int tail = intervals[i][1];
            int idx = Arrays.binarySearch(head, tail);

            if (idx >= 0) {
                res[i] = indices.get(head[idx]);
            } else {
                idx = -(idx + 1);

                if (idx < intervals.length) {
                    res[i] = indices.get(head[idx]);
                } else {
                    res[i] = -1;
                }
            }
        }

        return res;
    }
}
