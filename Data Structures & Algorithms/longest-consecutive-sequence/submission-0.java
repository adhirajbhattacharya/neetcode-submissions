class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) seen.add(num);
        int maxstreak = 0;

        for (int num : seen) {
            if (!seen.contains(num - 1)) {
                int streak = 1;
                int cnum = num;
                while (seen.contains(++cnum)) {
                    streak++;
                }
                maxstreak = Math.max(streak, maxstreak);
            }
        }
        return maxstreak;
    }
}