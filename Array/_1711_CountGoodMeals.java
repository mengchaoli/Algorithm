package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Constraints:
 *
 * 1 <= deliciousness.length <= 105
 * 0 <= deliciousness[i] <= 2^20
 * */

// We need to be aware of the data size for each question. Here deliciousness[i] <= 2^20, which means the biggest sum we can get is 2^20+2^20 = 2^21.
// So we can iterate i from 0 to 21 and calculate the power of 2 and then take advantage of the solution of two sums, which is using the target num to minus current num and see
// if we have that in our map already.

public class _1711_CountGoodMeals {
    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>();
        int mod = 1000000007;
        int res = 0;

        for (int num : deliciousness) {
            int pow = 1;
            for (int i = 0; i < 22; i++) {
                if (map.containsKey(pow - num)) {
                    res += map.get(pow - num);
                    res %= mod;
                }

                pow *= 2;
            }

            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return res;
    }
}
