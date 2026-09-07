class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> values = new HashSet<>();

        for (int num : nums) {
            values.add(num);
        }

        Set<Integer> seen = new HashSet<>();
        int longestConsecutiveLength = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int j = nums[i];
            if (seen.contains(j) || values.contains(j - 1)) continue;
            int len = 0;
            while (values.contains(j)) {
                len++;
                seen.add(j);
                j++;
            }
            longestConsecutiveLength = Math.max(len, longestConsecutiveLength);
        }
        return longestConsecutiveLength;
    }
}