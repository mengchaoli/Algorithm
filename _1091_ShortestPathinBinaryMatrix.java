import java.util.LinkedList;
import java.util.Queue;

public class _1091_ShortestPathinBinaryMatrix {

    int[][] dir = new int[][] {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        queue.offer(new int[] {0, 0});
        visited[0][0] = true;
        int ans = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                if (curr[0] == n - 1 && curr[1] == n - 1) {
                    return ans + 1;
                } else {
                    for (int j = 0; j < 8; j++) {
                        int dirX = curr[1] + dir[j][1];
                        int dirY = curr[0] + dir[j][0];

                        if (dirX >= 0 && dirX < n && dirY >= 0 && dirY < n && grid[dirY][dirX] == 0 && !visited[dirY][dirX]) {
                            queue.offer(new int[] {dirY, dirX});
                            visited[dirY][dirX] = true;
                        }
                    }
                }
            }
            ans++;
        }

        return -1;
    }

    public static void main(String[] args) {
        _1091_ShortestPathinBinaryMatrix text = new _1091_ShortestPathinBinaryMatrix();
        int[][] array = new int[][] {{0,1},{1,0}};
        System.out.println(text.shortestPathBinaryMatrix(array));

    }

}
