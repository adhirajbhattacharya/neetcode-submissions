class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        String longest = "";

        for (int i = 0; i < s.length() - 1; i++) {
            String curr = longestPalindrome(s, i, i);
            if (curr.length() > longest.length()) longest = curr;
            
            curr = longestPalindrome(s, i, i + 1);
            if (curr.length() > longest.length()) longest = curr;
        }

        return longest;
    }

    String longestPalindrome(String s, int left, int right) {
        if (s.charAt(left) != s.charAt(right)) return "";

        int n = s.length();
        while (left >= 0 && right < n) {
            if (s.charAt(left) != s.charAt(right)) break;
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}