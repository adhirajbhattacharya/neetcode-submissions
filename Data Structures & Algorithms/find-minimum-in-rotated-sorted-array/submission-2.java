class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        int l = 0, r = n - 1;
        if (nums[l] < nums[r]) return nums[l];

        while (l <= r) {
            int mid = l + (r - l) / 2;

            int found = check(nums, mid);
            if (found == 0) return nums[mid];
            if (found == 1) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    int check(int[] nums, int idx) {
        int n = nums.length;

        if (idx == n - 1) {
            if (nums[idx - 1] > nums[idx]) return 0;
            else return -1;
        }

        if (idx == 0) {
            if (nums[idx] < nums[n - 1]) return 0;
            else return 1;
        }

        if (nums[idx - 1] > nums[idx]) return 0;
        else if (nums[0] > nums[idx]) return -1;
        else return 1;
    }
}
