import java.util.*;

public class _1057_CampusBikes {
//    Solution 1:
//    public int[] assignBikes(int[][] workers, int[][] bikes) {
//        int n = workers.length;
//
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
//           int comp = Integer.compare(a[0], b[0]);
//           if (comp == 0) {
//               if (a[1] == b[1]) {
//                   return Integer.compare(a[2], b[2]);
//               } else {
//                   return Integer.compare(a[1], b[1]);
//               }
//           }
//           return comp;
//        });
//
//        for (int i = 0; i < n; i++) {
//            int[] worker = workers[i];
//
//            for (int j = 0; j < bikes.length; j++) {
//                int[] bike = bikes[j];
//                int dist = Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
//                pq.offer(new int[] {dist, i, j});
//            }
//        }
//
//        int[] res = new int[n];
//        Arrays.fill(res, -1);
//
//        Set<Integer> assignedBike = new HashSet<>();
//
//        while (assignedBike.size() < n) {
//            int[] curr = pq.poll();
//            if (res[curr[1]] == -1 && !assignedBike.contains(curr[2])) {
//                res[curr[1]] = curr[2];
//                assignedBike.add(curr[2]);
//            }
//        }
//
//        return res;
//
//    }
    //Solution 2
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        List<int[]>[] distances = new ArrayList [2001];

        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int dist = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
                if (distances[dist] == null) {
                    distances[dist] = new ArrayList<>();
                }
                distances[dist].add(new int[] {i, j});
            }
        }

        boolean[] workersAssigned = new boolean[workers.length];
        boolean[] bikesAssigned = new boolean[bikes.length];
        int[] res = new int[workers.length];

        for (int i = 0; i < distances.length; i++) {
            if (distances[i] == null) {
                continue;
            }
            for (int[] pair : distances[i]) {
                if (workersAssigned[pair[0]] == true || bikesAssigned[pair[1]] == true) {
                    continue;
                }
                res[pair[0]] = pair[1];
                workersAssigned[pair[0]] = true;
                bikesAssigned[pair[1]] = true;
            }
        }

        return res;

    }
}
