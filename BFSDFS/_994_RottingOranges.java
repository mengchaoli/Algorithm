package BFSDFS;

import java.util.LinkedList;
import java.util.Queue;

public class _994_RottingOranges {
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1 ,0}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int totalFresh = 0;
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    totalFresh++;
                } else if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        if (totalFresh == 0) {
            return 0;
        }

        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                totalFresh = expand(grid, current, queue, totalFresh);
            }
        }

        return totalFresh == 0 ? count - 1 : -1;
    }

    private int expand(int[][] grid, int[] current, Queue<int[]> queue, int totalFresh) {
        for (int[] d : dirs) {
            int x = current[0] + d[0];
            int y = current[1] + d[1];

            if (x < grid.length && x >= 0 && y < grid[0].length && y >= 0) {
                if (grid[x][y] == 1) {
                    grid[x][y] = 2;
                    totalFresh--;
                    queue.add(new int[]{x, y});
                }
            }
        }

        return totalFresh;
    }
}
