class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        
        Map<Character, Integer> freq = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxfreq = 0;
        int maxlength = 0;

        for (int i = 0; i < n; i++) {
            right = i;
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            maxfreq = Math.max(maxfreq, freq.get(c));

            while (right - left + 1 - maxfreq > k) {
                char l = s.charAt(left);
                freq.put(l, freq.get(l) - 1);
                left++;
            }

            maxlength = Math.max(maxlength, right - left + 1);
        }

        return maxlength;
    }
}
