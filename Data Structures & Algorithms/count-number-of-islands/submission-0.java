class Solution {
    int[][] dir = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return count;
    }

    void dfs(char[][] grid, int x, int y, int m, int n) {
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != '1') return;
        grid[x][y] = '2';
        for (int[] d : dir) {
            int r = x + d[0], c = y + d[1];
            dfs(grid, r, c, m, n);
        }
    }
}