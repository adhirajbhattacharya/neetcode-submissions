public class Solution {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        Pair[] dp = new Pair[n];
        Pair result = lengthOfLIS(nums, 0, n, dp);
        return Math.max(result.incl, result.excl);
    }

    private Pair lengthOfLIS(int[] nums, int st, int n, Pair[] dp) {
        if (st == n) return new Pair(0, 0);
        if (dp[st] != null) return dp[st];
        int incl = 1;
        for (int i = st + 1; i < n; i++) {
            if (nums[i] > nums[st]) {
                incl = Math.max(incl, 1 + lengthOfLIS(nums, i, n, dp).incl);
            }
        }
        Pair exclRes = lengthOfLIS(nums, st + 1, n, dp);
        int excl = Math.max(exclRes.incl, exclRes.excl);
        dp[st] = new Pair(incl, excl);
        return dp[st];
    }
}

class Pair {
    int incl;
    int excl;

    Pair(int incl, int excl) {
        this.incl = incl;
        this.excl = excl;
    }
}
