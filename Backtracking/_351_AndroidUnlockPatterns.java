package Backtracking;

public class _351_AndroidUnlockPatterns {
    public int numberOfPatterns(int m, int n) {
        int res = 0;
        int[][] skip = new int[10][10];
        boolean[] visited = new boolean[10];

        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;

        for (int i = m; i <= n; i++) {
            res += DFS(visited, skip, 1, i - 1) * 4;
            res += DFS(visited, skip, 2, i - 1) * 4;
            res += DFS(visited, skip, 5, i - 1);
        }

        return res;
    }

    private int DFS(boolean[] visited, int[][] skip, int curr, int remain) {
        if (remain == 0) return 1;
        int res = 0;

        for (int i = 1; i <= 9; i++) {
            visited[curr] = true;

            if (!visited[i] && (skip[curr][i] == 0 || visited[skip[curr][i]])) {
                res += DFS(visited, skip, i, remain - 1);
            }

            visited[curr] = false;
        }

        return res;
    }
}
