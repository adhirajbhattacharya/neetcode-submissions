class Solution {
    int MAX = 100_000;
    public int coinChange(int[] coins, int amount) {
        int count = coinChangeRec(coins, amount, new HashMap<>());
        return count == MAX ? -1 : count;
    }

    int coinChangeRec(int[] coins, int amount, Map<Integer, Integer> memo) {
        if (memo.containsKey(amount)) return memo.get(amount);

        if (amount == 0) return 0;

        int count = MAX;

        for (int coin : coins) {
            int rem = amount - coin;
            if (rem < 0) continue;
            count = Math.min(count, 1 + coinChangeRec(coins, rem, memo));
        }

        memo.put(amount, count);
        return count;
    }
}