/*
* Given a set of points in the xy-plane, determine the minimum area of a rectangle formed from these points, with sides parallel to the x and y axes.

If there isn't any rectangle, return 0.



Example 1:

Input: [[1,1],[1,3],[3,1],[3,3],[2,2]]
Output: 4
Example 2:

Input: [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
Output: 2


Note:

1 <= points.length <= 500
0 <= points[i][0] <= 40000
0 <= points[i][1] <= 40000
All points are distinct.
* */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _939_MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] point : points) {
            if (!map.containsKey(point[0])) {
                map.put(point[0], new HashSet<>());
            }
            map.get(point[0]).add(point[1]);
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] == points[j][0] || points[i][1] == points[j][1]) {
                    continue;
                }
                if (map.get(points[i][0]).contains(points[j][1]) && map.get(points[j][0]).contains(points[i][1])) {
                    result = Math.min(result, Math.abs(points[i][0] - points[j][0]) * Math.abs(points[i][1] - points[j][1]));
                }
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
