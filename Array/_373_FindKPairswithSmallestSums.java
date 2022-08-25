package Array;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class _373_FindKPairswithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.offer(new int[]{ nums1[i], nums2[0], 0 });
        }

        List<List<Integer>> res = new LinkedList<>();

        while (k-- > 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();
            res.add(List.of(cur[0], cur[1]));
            if (cur[2] == nums2.length - 1) {
                continue;
            }
            pq.offer(new int[]{ cur[0], nums2[cur[2] + 1], cur[2] + 1 });
        }

        return res;
    }
}
