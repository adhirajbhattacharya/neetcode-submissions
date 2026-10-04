class Solution {
    public String longestPalindrome(String s) {
        String longest = "";

        for (int i = 0; i < s.length(); i++) {
            String curr = longestPalindrome(s, i);
            if (curr.length() > longest.length()) longest = curr;
        }

        return longest;
    }

    String longestPalindrome(String s, int idx) {
        int n = s.length();

        int left = idx, right = idx;
        String longest = "";

        int l = left - 1, r = right + 1;
        while (l >= 0 && r < n) {
            if (s.charAt(l) != s.charAt(r)) break;
            left--;
            right++;
            l--;
            r++;
        }

        longest = s.substring(left, right + 1);

        if (idx + 1 == n || s.charAt(idx) != s.charAt(idx + 1)) return longest;

        left = idx;
        right = idx + 1;
        
        l = left - 1;
        r = right + 1;
        while (l >= 0 && r < n) {
            if (s.charAt(l) != s.charAt(r)) break;
            left--;
            right++;
            l--;
            r++;
        }

        if (right - left + 1 > longest.length()) longest = s.substring(left, right + 1);

        return longest;
    }
}