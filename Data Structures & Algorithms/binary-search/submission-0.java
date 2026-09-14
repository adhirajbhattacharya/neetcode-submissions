class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        int ans = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (isValidSolutionSpace(nums, target, mid)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return ans != -1 && nums[ans] == target ? ans : -1;
    }

    boolean isValidSolutionSpace(int nums[], int target, int idx) {
        return target <= nums[idx];
    }
}