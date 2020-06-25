import java.util.Comparator;
import java.util.PriorityQueue;

public class _407_TrappingRainWaterII {

    class Cell {
        int r;
        int c;
        int height;

        public Cell(int r, int c, int height) {
            this.c = c;
            this.r = r;
            this.height = height;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        PriorityQueue<Cell> pq = new PriorityQueue<>(new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                return o1.height - o2.height;
            }
        });
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < n; i++) {
            visited[0][i] = true;
            visited[m - 1][i] = true;
            pq.add(new Cell(0, i, heightMap[0][i]));
            pq.add(new Cell(m - 1, i, heightMap[m - 1][i]));
        }

        for (int i = 1; i < m - 1; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            pq.add((new Cell(i, 0, heightMap[i][0])));
            pq.add(new Cell(i, n - 1, heightMap[i][n - 1]));
        }

        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int res = 0;

        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            for (int[] dir : dirs) {
                int row = cell.r + dir[0];
                int col = cell.c + dir[1];
                if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]) {
                    visited[row][col] = true;
                    res += Math.max(0, cell.height - heightMap[row][col]);
                    pq.add(new Cell(row, col, Math.max(cell.height, heightMap[row][col])));
                }
            }
        }

        return res;
    }
}
