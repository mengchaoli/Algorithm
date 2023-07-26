package Graph.Dijkstra;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class _1631_PathWithMinimumEffort {
    class State {
        int x;
        int y;
        int weight;

        State(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        // step 1: construct adjacency list. purpose is to access current node's adjacent nodes (neighbors). not needed here;

        // step 2:
        int m = heights.length, n = heights[0].length;
        int[][] minEffortTo = new int[m][n];
        // fill dp table with initial values. this is per problem, need to figure out filling with min value or max value
        for (int i = 0; i < m; i++) {
            Arrays.fill(minEffortTo[i], Integer.MAX_VALUE);
        }
        // starting node to starting node effort is 0;
        minEffortTo[0][0] = 0;

        // priorityqueue. make sure what the sorting rule is
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        // put first node into queue
        pq.add(new State(0, 0, 0));

        while (!pq.isEmpty()) {
            State curr = pq.poll();
            int currX = curr.x;
            int currY = curr.y;
            int currWeight = curr.weight;

            if (currX == m - 1 && currY == n - 1) {
                return currWeight;
            }

            if (currWeight > minEffortTo[currX][currY]) {
                continue;
            }

            for (int[] neighbor : adj(heights, currX, currY)) {
                int nextX = neighbor[0], nextY = neighbor[1];
                int effortToNext = Math.max(
                        minEffortTo[currX][currY],
                        Math.abs(heights[currX][currY] - heights[nextX][nextY])
                );
                if (minEffortTo[nextX][nextY] > effortToNext) {
                    minEffortTo[nextX][nextY] = effortToNext;
                    pq.offer(new State(nextX, nextY, effortToNext));
                }
            }
        }

        return -1;
    }

    private List<int[]> adj(int[][] matrix, int x, int y) {
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        List<int[]> neighbors = new LinkedList<>();

        for (int[] dir : dirs) {
            if (x + dir[0] >= 0 && x + dir[0] < matrix.length && y + dir[1] >= 0 && y + dir[1] < matrix[0].length) {
                neighbors.add(new int[]{x + dir[0], y + dir[1]});
            }
        }

        return neighbors;
    }
}
