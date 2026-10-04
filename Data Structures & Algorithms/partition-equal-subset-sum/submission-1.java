class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum % 2 == 1) return false;

        int target = sum / 2;
        Arrays.sort(nums);
        return canSum(nums, 0, target, new Boolean[nums.length][target + 1]);
    }

    boolean canSum(int[] nums, int idx, int target, Boolean[][] memo) {
        int n = nums.length;
        if (target == 0) return true;
        if (idx == n) return false;

        if (memo[idx][target] != null) return memo[idx][target];

        boolean canSum = false;

        for (int i = idx; i < n; i++) {
            int rem = target - nums[i];
            if (rem < 0 || canSum) break;
            canSum = canSum || canSum(nums, i + 1, rem, memo);
        }

        memo[idx][target] = canSum;

        return canSum;
    }
}