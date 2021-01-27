import java.util.Arrays;

public class _435_NonoverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        // two angels: one is sorting the starting time, one is sorting the end time. here we sorting the end time
        if (intervals == null || intervals.length <= 1 || intervals[0].length <= 1) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> (a[1] - b[1]));

        int prev = intervals[0][1];
        int drop = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prev) {
                drop++;
            } else {
                // update endtime
                prev = intervals[i][1];
            }
        }

        return drop;

//        if (intervals == null || intervals.length <= 1 || intervals[0].length <= 1) {
//            return 0;
//        }
//        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
//
//        int[] prev = intervals[0];
//        int drop = 0;
//
//        for (int i = 1; i < intervals.length; i++) {
//            if (intervals[i][0] < prev[1]) { // this means we got overlap, coz current start time is less than previous end time
//                drop++;
//                // the only thing we need to pay attention to in this solution is: if intervals[i][1] < prev[1], this means current one is fully included by prev one, so we keep the earlier end time to save room for later intervals
//                if (intervals[i][1] < prev[1]) {
//                    prev = intervals[i];
//                }
//            } else {
//                prev = intervals[i];
//            }
//        }
//
//        return drop;
    }
}
