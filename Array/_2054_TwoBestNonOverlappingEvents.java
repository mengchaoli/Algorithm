package Array;

import java.util.Arrays;

public class _2054_TwoBestNonOverlappingEvents {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;

        Arrays.sort(events, (a, b) -> (a[0] - b[0]));

        int[] rollingMax = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            rollingMax[i] = Math.max(rollingMax[i + 1], events[i][2]);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            int start = events[i][0], end = events[i][1], value = events[i][2];
            // it's possible that this single interval can be the max value
            res = Math.max(res, value);

            // find next max value index among post non-overlapping intervals
            int nextIdx = binarySearch(end, events);

            // need to make sure nextIdx < n
            if (nextIdx < n) {
                res = Math.max(res, value + rollingMax[nextIdx]);
            }
        }

        return res;
    }

    private int binarySearch(int end, int[][] events) {
        int left = 0, right = events.length;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (events[mid][0] <= end) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
