class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);

        int n = nums.length;
        
        int lo = pivot, hi = n - 1 + pivot;

        int ans = n;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int t = nums[mid % n];

            if (target > t) {
                lo = mid + 1;
            } else {
                ans = mid % n;
                hi = mid - 1;
            }
        }

        if (ans >= n) return -1;
        return nums[ans] == target ? ans : -1;
    }

    int findPivot(int[] nums) {
        int n = nums.length;

        int lo = 0, hi = n - 1;
        int ans = n;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int t = nums[mid];

            if (t > nums[n - 1]) {
                lo = mid + 1;
            } else {
                ans = mid;
                hi = mid - 1;
            }
        }
        return ans;
    }
}