class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() < 1) return true;

        int i = 0, j = s.length() - 1;

        while (i <= j) {
            char a = Character.toLowerCase(s.charAt(i));
            char b = Character.toLowerCase(s.charAt(j));
            
            if (!Character.isLetterOrDigit(a)) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(b)) {
                j--;
                continue;
            }
            
            if (a != b) return false;
            i++;
            j--;
        }

        return true;
    }
}
