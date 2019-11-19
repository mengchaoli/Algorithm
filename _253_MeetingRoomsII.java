//The numbers of the intervals give chronological orders
//When an ending event occurs, there must be a starting event has happened before that, where “happen before” is defined by the chronological orders given by the intervals
//Meetings that started which haven’t ended yet have to be put into different meeting rooms, and the number of rooms needed is the number of such meetings

import java.util.Arrays;

public class _253_MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        int len = intervals.length;
        int[] starts = new int[len];
        int[] ends = new int[len];

        for (int i = 0; i < len; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int rooms = 0;
        int endItr = 0;

        for (int i = 0; i < len; i++) {
            if (starts[i] < ends[endItr]) {
                rooms++;
            } else {
                endItr++;
            }
        }

        return rooms;
    }
}
