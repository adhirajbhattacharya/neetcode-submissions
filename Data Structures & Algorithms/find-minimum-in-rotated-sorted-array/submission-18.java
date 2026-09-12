class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        int l = 0, r = n - 1;
        if (nums[l] < nums[r]) return nums[l];
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] <= nums[0] && nums[mid] <= nums[n - 1]) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return nums[ans];
    }
}
