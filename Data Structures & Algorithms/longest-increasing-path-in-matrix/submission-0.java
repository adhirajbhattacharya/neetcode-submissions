class Solution {
    static int[] DIR = {-1, 0, 1, 0, -1};
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == -1)
                    longestIncreasingPath(matrix, m, n, i, j, dp);
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    private void longestIncreasingPath(int[][] matrix, int rmax, int cmax, int idx_i, int idx_j, int[][]dp) {
        if (dp[idx_i][idx_j] != -1) return;
        int max = 1;
        for (int i = 0; i < DIR.length - 1; i++) {
            int r = idx_i + DIR[i];
            int c = idx_j + DIR[i + 1];
            if (isValid(r, c, rmax, cmax) && matrix[r][c] > matrix[idx_i][idx_j]) {
                if (dp[r][c] == -1)
                    longestIncreasingPath(matrix, rmax, cmax, r, c, dp);
                max = Math.max(max, dp[r][c] + 1);
            }
        }
        dp[idx_i][idx_j] = max;
    }

    private boolean isValid(int r, int c, int rmax, int cmax) {
        return r >= 0 && c >= 0 && r < rmax && c < cmax;
    }
}
