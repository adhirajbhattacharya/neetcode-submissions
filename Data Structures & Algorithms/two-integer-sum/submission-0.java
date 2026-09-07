class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int remainder = target - nums[i];
            if (seen.containsKey(remainder)) {
                int j = seen.get(remainder);
                return i < j ? new int[] {i, j} : new int[] {j, i};
            }
            seen.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}
