package BFSDFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _417_PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, Integer.MIN_VALUE, i, 0);
            dfs(heights, atlantic, Integer.MIN_VALUE, i, n - 1);
        }

        for (int i = 0; i < n; i++) {
            dfs(heights, pacific, Integer.MIN_VALUE, 0, i);
            dfs(heights, atlantic, Integer.MIN_VALUE, m - 1, i);
        }

        List<List<Integer>> res = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public void dfs(int[][] heights, boolean[][] visited, int height, int x, int y) {
        int m = heights.length, n = heights[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || heights[x][y] < height) {
            return;
        }
        visited[x][y] = true;

        for (int[] dir : dirs) {
            dfs(heights, visited, heights[x][y], x + dir[0], y + dir[1]);
        }
    }
}
