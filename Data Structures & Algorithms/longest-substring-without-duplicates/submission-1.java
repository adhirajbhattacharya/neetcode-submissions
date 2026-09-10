class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        boolean[] exists = new boolean[95];
        int maxwindow = 0;
        int left = 0, right = 0;

        for (int i = 0; i < n; i++) {
            right = i;
            char r = s.charAt(right);

            while (exists[r - 32]) {
                char l = s.charAt(left);
                exists[l - 32] = false;
                left++;
            }

            maxwindow = Math.max(maxwindow, right - left + 1);
            exists[r - 32] = true;
        }

        return maxwindow;
    }
}
