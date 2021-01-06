package Array;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class _846_HandofStraights {
    // Solution 1: TreeMap.
    // TreeMap is a data structure whose key set is ordered;
    // Intuition:
//    public boolean isNStraightHand(int[] hand, int W) {
//        Map<Integer, Integer> map = new TreeMap<>();
//        for (int i : hand) {
//            map.put(i, map.getOrDefault(i, 0) + 1);
//        }
//
//        for (int it : map.keySet()) {
//            if (map.get(it) > 0) {
//                for (int i = W - 1; i >= 0; i--) {
//                    if (map.getOrDefault(it + i, 0) < map.get(it)) {
//                        return false;
//                    }
//
//                    map.put(it + i, map.get(it + i) - map.get(it));
//                }
//            }
//        }
//
//        return true;
//    }

    // Solution 2:
    public boolean isNStraightHand(int[] hand, int W) {
        int n = hand.length;
        if (n % W != 0) {
            return false;
        }

        int[] visited = new int[n];
        Arrays.sort(hand);

        for (int i = 0; i < n; i++) {
            if (visited[i] == 1) {
                continue;
            }

            int width = 0; // to calculate the width, starting from index i, and compare this to W to see if this frame is good
            int prev = 0;
            for (int j = i; j < n; j++) {
                if (visited[j] == 0) {
                    if (width == 0) {
                        prev = hand[j];
                        width++;
                    } else if (prev + 1 == hand[j]) {
                        width++;
                        prev = hand[j];
                        visited[j] = 1;
                    }

                    if (width == W) {
                        break;
                    }
                }
            }

            if (width != W) {
                return false;
            }
        }

        return true;
    }
}
