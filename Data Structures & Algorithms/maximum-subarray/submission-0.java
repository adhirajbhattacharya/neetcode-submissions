class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length, l = 0, r = 0;

        int max = Integer.MIN_VALUE;
        int sum = 0;

        while (l < n && r < n) {
            sum += nums[r];

            max = Math.max(max, sum);

            if (sum < 0) {
                sum = 0;
                l = r + 1;
                r = l;
            } else {
                r++;
            }
        }

        return max;
    }
}