package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * there is math problem here:
 * if a % k = c, b % k = c, then (a - c) = n * k, n is 1, 2, 3,... etc
 * */

public class _523_ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // this is necessary

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum % k)) {
                if (i - map.get(sum % k) > 1) {
                    return true;
                }
            } else {
                map.put(sum % k, i);
            }
        }

        return false;
    }
}
