class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        if (len == 0) return true;
        Boolean[] dp = new Boolean[len];
        return wordBreak(s, wordDict, 0, len, dp);
    }

    private boolean wordBreak(String s, List<String> wordDict, int idx, int len, Boolean[] dp) {
        if (idx == len) return true;
        if (dp[idx] != null) return dp[idx];
        boolean res = false;
        for (String w : wordDict) {
            if (s.substring(idx).startsWith(w))
                res = wordBreak(s, wordDict, idx + w.length(), len, dp);
            if (res) {
                dp[idx] = res;
                return res;
            }
        }
        dp[idx] = res;
        return res;
    }
}
