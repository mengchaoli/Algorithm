import java.util.LinkedList;
import java.util.Queue;

public class _909_SnakesAndLadders {

    //BFS

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        boolean[] visited = new boolean[n * n + 1];
        for (int move = 0; !queue.isEmpty(); move++) {
            for (int size = queue.size(); size > 0; size--) {
                int num = queue.poll();
                if (num == n * n) return move;
                if (visited[num]) continue;
                visited[num] = true;
                for (int i = 1; i <= 6 && num + i <= n * n ; i++) {
                    int next = num + i;
                    int value = getBoardValue(board, next);
                    next = value == -1 ? next : value;
                    if (!visited[next]) {
                        queue.offer(next);
                    }
                }
            }
        }
        return -1;
    }

    private int getBoardValue(int[][] board, int num) {
        int n = board.length;
        int r = (num - 1) / n;
        int x = n - 1 - r;
        int y = r % 2 == 0 ? num - 1 - r * n : n + r * n - num;
        return board[x][y];
    }

    public static void main(String[] args) {
        _909_SnakesAndLadders solution = new _909_SnakesAndLadders();
        int[][] array = {{-1,-1,-1,-1,-1,-1},
                        {-1,-1,-1,-1,-1,-1},
                        {-1,-1,-1,-1,-1,-1},
                        {-1,35,-1,-1,13,-1},
                        {-1,-1,-1,-1,-1,-1},
                        {-1,15,-1,-1,-1,-1}};
        solution.snakesAndLadders(array);
    }
}
