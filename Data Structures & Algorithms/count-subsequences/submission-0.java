class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (m > n) return 0;
        if (s.equals(t)) return 1;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        return numDistinct(s, t, 0, 0, n, m, dp);
    }

    public int numDistinct(String s, String t, int sst, int tst, int slen, int tlen, int[][] dp) {
        if (tst == tlen) return 1;
        if (sst == slen) return 0;
        if (dp[sst][tst] != -1) return dp[sst][tst];
        int count = 0;
        for (int i = sst; i < slen; i++) {
            if (s.charAt(sst) == t.charAt(tst))
                count = numDistinct(s, t, sst + 1, tst + 1, slen, tlen, dp) + numDistinct(s, t, sst + 1, tst, slen, tlen, dp);
            else 
                count = numDistinct(s, t, sst + 1, tst, slen, tlen, dp);
        }
        dp[sst][tst] = count;
        return count;
    }
}
