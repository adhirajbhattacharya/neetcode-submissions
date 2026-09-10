class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        int l = 0, r = n - 1;
        if (nums[l] < nums[r]) return nums[l];

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (mid > 0 && nums[mid - 1] > nums[mid]) return nums[mid];
            if (mid < n - 1 && nums[mid] > nums[mid + 1]) return nums[mid + 1];

            if (nums[0] < nums[mid]) l = mid + 1;
            else r = mid - 1;
        }

        return -1;
    }
}
