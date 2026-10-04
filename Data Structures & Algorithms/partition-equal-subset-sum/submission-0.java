class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum % 2 == 1) return false;

        int target = sum / 2;
        return canSum(nums, 0, target, new Boolean[nums.length][target + 1]);
    }

    boolean canSum(int[] nums, int idx, int target, Boolean[][] memo) {
        if (target == 0) return true;
        if (idx == nums.length) return false;

        if (memo[idx][target] != null) return memo[idx][target];

        boolean canSum = false;
        
        if (target - nums[idx] >= 0) canSum = canSum || canSum(nums, idx + 1, target - nums[idx], memo);
        canSum = canSum || canSum(nums, idx + 1, target, memo);

        memo[idx][target] = canSum;

        return canSum;
    }
}