package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _781_RabbitsinForest {
    public int numRabbits(int[] answers) {
        // solution 1: hashmap

//        Map<Integer, Integer> hm = new HashMap<>();
//        int res = 0;
//
//        for (int i : answers) {
//            if (i == 0) {
//                res++;
//                continue;
//            }
//            if (!hm.containsKey(i)) {
//                // if this is the new color we met, we just need to add (i + 1) into res, and put it into hashmap for future use
//                res += i + 1;
//                hm.put(i, 0);
//            } else {
//                // this means we this one is possible the same color with someone we asked previously
//                // we just need to count how many we have met for the same color. and if it matches i (because we stored 0 at the beginning), we can assume they belong to the same color
//                // and remove this color from hashmap
//                hm.put(i, hm.get(i) + 1);
//                if (hm.get(i) == i) {
//                    hm.remove(i);
//                }
//            }
//        }
//
//        return res;

        // solution 2: double pointer

        // first sort this array (or you can use map too)
        Arrays.sort(answers);

        // double pointer template:
        int left = 0, right = 0;
        int size = answers.length, res = 0;

        while (right < size) {
            while (right < size && answers[left] == answers[right]) {
                right++;
            }

            // after that while loop we can know how many same numbers we have:
            int num = right - left;
            int value = answers[left]; // retrieve the value
            int set = num / (value + 1); // how many sets we have. we divided by (value + 1) because if the value is n, that means there should be (n + 1) same color rabbits
            int remains = num % (value + 1); // count how many remains;

            res += set * (value + 1) + (remains == 0 ? 0 : value + 1); // e.g [3,3], there should be [3,3,3,3] total 4 rabbits to be the same color group, but we only have [3,3] in array, so we add 4 (which is value + 1) to res

            left = right; // don't forget to update pointer
        }

        return res;
    }
}
