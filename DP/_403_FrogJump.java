package DP;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _403_FrogJump {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        map.put(stones[0], new HashSet<>());
        map.get(stones[0]).add(1);

        for (int i = 1; i < stones.length; i++) {
            map.put(stones[i], new HashSet<>());
        }

        for (int stone : stones) {
            for (int step : map.get(stone)) {
                int reach = stone + step;
                if (reach == stones[stones.length - 1]) {
                    return true;
                }

                Set<Integer> set = map.get(reach);

                if (set != null) {
                    map.get(reach).add(step);
                    if (step - 1 > 0) {
                        map.get(reach).add(step - 1);
                    }
                    map.get(reach).add(step + 1);
                }
            }
        }

        return false;
    }
}
