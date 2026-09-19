class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) return 0;

        Map<Character, Integer> freq = new HashMap<>();

        int max = 0, len = 0;
        int l = 0, r = 0;

        while (l < n && r < n) {
            char c = s.charAt(r);
            Integer count = freq.getOrDefault(c, 0);

            while (count > 0) {
                char d = s.charAt(l);
                freq.put(d, freq.get(d) - 1);
                if (d == c) count--;
                len--;
                l++;
            }

            freq.put(c, freq.getOrDefault(c, 0) + 1);
            len++;
            max = Math.max(max, len);
            r++;
        }

        return max;
    }
}