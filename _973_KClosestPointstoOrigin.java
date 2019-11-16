
//Solution: PriorityQueue

//Note:
//When implement comparator for priorityqueue, return p1 - p2 means we are constructing a min heap;
//return p2 - p1 means we are constructing a max heap. In this problem, we want to maintain a max heap because
//when a closer point comes in, we need to poll out the root of the max heap which is the maximum point in the queue.
import java.util.PriorityQueue;

public class _973_KClosestPointstoOrigin {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > K) {
                pq.poll();
            }
        }

        int[][] res = new int[K][];
        for (int i = 0; i < K; i++) {
            res[i] = pq.poll();
        }

        return res;
    }
}
