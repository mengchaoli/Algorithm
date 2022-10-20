package BFSDFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _2059_MinimumOperationstoConvertNumber {
    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        int res = 0;

        q.offer(start);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int value = q.poll();

                if (value == goal) {
                    return res;
                }

                if (value > 1000 || value < 0 || set.contains(value)) {
                    continue;
                }

                set.add(value);

                for (int num : nums) {
                    q.offer(value + num);
                    q.offer(value - num);
                    q.offer(value ^ num);
                }
            }

            res++;
        }

        return -1;
    }
}
