class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        return longestCommonSubsequence(text1, text2, 0, 0, n, m, dp);
    }

    public int longestCommonSubsequence(String s1, String s2, int idx1, int idx2, int len1, int len2, int[][] dp) {
        if (idx1 == len1 || idx2 == len2) return 0;
        if (dp[idx1][idx2] != -1) return dp[idx1][idx2];
        int count = 0;

        if (s1.charAt(idx1) == s2.charAt(idx2))
            count = 1 + longestCommonSubsequence(s1, s2, idx1 + 1, idx2 + 1, len1, len2, dp);

        count = Math.max(
            count,
            longestCommonSubsequence(s1, s2, idx1, idx2 + 1, len1, len2, dp)
        );

        count = Math.max(
            count,
            longestCommonSubsequence(s1, s2, idx1 + 1, idx2, len1, len2, dp)
        );

        dp[idx1][idx2] = count;
        return count;
    }
}
