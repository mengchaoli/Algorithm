package Array;

import java.util.HashMap;
import java.util.Map;

public class _1010_PairsofSongsWithTotalDurationsDivisibleby60 {

    // Solution 1: due to: 1 <= time.length <= 6 * 104, 1 <= time[i] <= 500
//    public int numPairsDivisibleBy60(int[] time) {
//        int res = 0;
//        int second = 60;
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for (int i = 2; i <= 17; i++) {
//            for (int j = 0; j < time.length; j++) {
//                if (map.containsKey(second - time[j])) {
//                    res += map.get(second - time[j]);
//                }
//                map.put(time[j], map.getOrDefault(time[j], 0) + 1);
//            }
//
//            map = new HashMap<>();
//            second = 60 * i;
//        }
//
//        return res;
//    }

    // Solution: when the question is about %, dont forget to use an array to store remainders, and if a%60 + b%60 = 60, this means (a+b)%60=0
    public int numPairsDivisibleBy60(int[] time) {
        int[] remainders = new int[60];
        int count = 0;

        for (int t : time) {
            if (t % 60 == 0) {
                count += remainders[0];
            } else {
                count += remainders[60 - t % 60];
            }

            // dont forget to add this t into array
            remainders[t % 60]++;
        }

        return count;
    }

}
