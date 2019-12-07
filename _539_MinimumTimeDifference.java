import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Solution:
//Because time is a successive thing, we can stretch all the incoming timePoint to a line using Minutes to stand for them. Just dont forget to compare the corner case;
public class _539_MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        int result = Integer.MAX_VALUE;
        List<Integer> time = new ArrayList<>();

        for (String timePoint : timePoints) {
            int H = Integer.valueOf(timePoint.substring(0, 2));
            time.add(H * 60 + Integer.valueOf(timePoint.substring(3, 5)));
        }

        Collections.sort(time, (Integer a, Integer b) -> a - b);

        for (int i = 1; i < time.size(); i++) {
            result = Math.min(result, time.get(i) - time.get(i - 1));
        }

        int corner = time.get(0) + 1440 - time.get(time.size() - 1);

        return Math.min(result, corner);
    }
}
