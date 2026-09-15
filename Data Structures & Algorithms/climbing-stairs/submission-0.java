class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    public int climbStairs(int n) {
        // return climbStairsTopDown(n);
        return climbStairsBottomUp(n);
    }
    
    public int climbStairsBottomUp(int n) {
        if (n == 1) return 1;
        int[] memo = new int[n + 1];
        memo[1] = 1;
        memo[2] = 2;
        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n];
    }

    public int climbStairsTopDown(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;

        Integer ans = memo.get(n);

        if (ans == null) {
            ans = climbStairs(n - 1) + climbStairs(n - 2);
            memo.put(n, ans);
        }

        return ans;
    }
}