class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int hold = -1;
        return maxProfit(prices, 0, n, hold);
    }

    private int maxProfit(int[] prices, int idx, int n, int hold) {
        if (idx >= n) return hold == -1 ? 0 : (-1) * hold;
        int p = 0;
        if (hold == -1) {
            p = Math.max(p, maxProfit(prices, idx + 1, n, prices[idx]));
            p = Math.max(p, maxProfit(prices, idx + 1, n, hold));
        } else {
            p = Math.max(p, prices[idx] - hold + maxProfit(prices, idx + 2, n, -1));
            p = Math.max(p, maxProfit(prices, idx + 1, n, hold));
        }
        return p;
    }
}
