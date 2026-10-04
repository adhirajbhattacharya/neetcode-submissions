class Solution {
    public int uniquePaths(int m, int n) {
        return uniquePathsRec(m, n, new Integer[m + 1][n + 1]);
    }

    int uniquePathsRec(int m, int n, Integer[][] memo) {
        if (m == 1 || n == 1) return 1;
        if (memo[m][n] != null) return memo[m][n];
        memo[m][n] = uniquePathsRec(m - 1, n, memo) + uniquePathsRec(m, n - 1, memo);
        return memo[m][n];
    }
}