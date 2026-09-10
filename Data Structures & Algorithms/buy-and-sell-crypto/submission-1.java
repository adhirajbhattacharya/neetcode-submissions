class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxprofit = 0;
        int minpricetillnow = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            maxprofit = Math.max(maxprofit, prices[i] - minpricetillnow);
            if (minpricetillnow > prices[i]) minpricetillnow = prices[i];
        }

        return maxprofit;
    }
}

