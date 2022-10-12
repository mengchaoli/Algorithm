package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * key is to transform the formula
 * j - i != nums[j] - nums[i]  ==>  j - nums[j] != i - nums[i]
 *
 * and badPairs = totalPairs - goodPairs. when index is i, there are total i pairs (0 - nums[0], 1 - nums[1], ..., i - nums[i])
 * */

public class _2364_CountNumberofBadPairs {
    public long countBadPairs(int[] nums) {
        long res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int prev = map.getOrDefault(i - nums[i], 0);
            res += i - prev;
            map.put(i - nums[i], prev + 1);
        }

        return res;
    }
}
