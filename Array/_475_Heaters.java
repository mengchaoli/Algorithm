package Array;

import java.util.Arrays;

public class _475_Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int res = 0;

        for (int house : houses) {
            int idx = Arrays.binarySearch(heaters, house);

            if (idx < 0) {
                idx = -(idx + 1);

                int dist1 = idx - 1 >= 0 ? house - heaters[idx - 1] : Integer.MAX_VALUE;
                int dist2 = idx < heaters.length ? heaters[idx] - house : Integer.MAX_VALUE;

                res = Math.max(res, Math.min(dist1, dist2));
            }
        }

        return res;
    }
}
