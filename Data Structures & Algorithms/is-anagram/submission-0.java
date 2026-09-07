class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int len = s.length();
        int[] count = new int[26];

        for (int i = 0; i < len; i++) {
            int first = s.charAt(i) - 'a';
            int second = t.charAt(i) - 'a';
            
            count[first] += 1;
            count[second] -= 1;
        }

        for (int i : count) {
            if (i != 0) return false;
        }

        return true;
    }
}
