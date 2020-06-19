package BFSDFS;

public class _200_NumberofIslands {
    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    public void bfs(char[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1') {
            grid[i][j] = '0';
            bfs(grid, i, j + 1);
            bfs(grid, i, j - 1);
            bfs(grid,i + 1, j);
            bfs(grid, i - 1, j);
        }
    }

    public static void main(String[] args) {
        _200_NumberofIslands test = new _200_NumberofIslands();
        char[][] grid = new char[][] {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(test.numIslands(grid));
    }
}
