package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _465_OptimalAccountBalancing {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] t : transactions) {
            map.put(t[0], map.getOrDefault(t[0], 0) + t[2]);
            map.put(t[1], map.getOrDefault(t[1], 0) - t[2]);
        }

        List<Integer> list = new ArrayList<>();

        for (int value : map.values()) {
            if (value != 0) {
                list.add(value);
            }
        }

        return backTracking(0, list);
    }

    private int backTracking(int k, List<Integer> list) {
        if (k == list.size()) {
            return 0;
        }
        int curr = list.get(k);
        if (curr == 0) {
            return backTracking(k + 1, list);
        }

        int min = Integer.MAX_VALUE;

        for (int i = k + 1; i < list.size(); i++) {
            int next = list.get(i);
            if (curr * next < 0) {
                list.set(i, curr + next);
                min = Math.min(min, 1 + backTracking(k + 1, list));
                // important
                list.set(i, next);

                if (curr + next == 0) {
                    break;
                }
            }
        }

        return min;
    }
}
