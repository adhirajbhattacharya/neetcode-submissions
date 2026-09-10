class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int BOUNDARY = 1_000_000;
        int minleft = 0, minright = BOUNDARY;

        int left = 0, right;

        for (int i = 0; i < s.length(); i++) {
            right = i;
            char r = s.charAt(right);
            freq.put(r, freq.getOrDefault(r, 0) - 1);
            
            while (allFreqLessThanZero(freq)) {
                if (right - left < minright - minleft) {
                    minleft = left;
                    minright = right;
                }
                char l = s.charAt(left);
                freq.put(l, freq.get(l) + 1);
                left++;
            }
        }
        return minright == BOUNDARY ? "" : s.substring(minleft, minright + 1);
    }

    boolean allFreqLessThanZero(Map<Character, Integer> freq) {
        for (int value : freq.values()) {
            if (value > 0) return false;
        }

        return true;
    }
}
