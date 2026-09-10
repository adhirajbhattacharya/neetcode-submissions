class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxprofit = 0;
        Deque<Key> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            Key curr = new Key(prices[i], 0);
            
            if (stack.isEmpty()) {
                stack.push(curr);
                continue;
            }

            while (!stack.isEmpty() && curr.price > stack.peekFirst().price) {
                Key prev = stack.pop();
                curr.maxprofit = Math.max(curr.maxprofit, prev.maxprofit + (curr.price - prev.price));
            }

            maxprofit = Math.max(maxprofit, curr.maxprofit);

            stack.push(curr);
        }

        return maxprofit;
    }
}

class Key {
    int price;
    int maxprofit;

    Key(int price, int maxprofit) {
        this.price = price;
        this.maxprofit = maxprofit;
    }
}
