class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) return "";

        int[] counts = new int[52];

        for (int i = 0; i < n; i++) {
            char c = t.charAt(i);
            int idx = getCountIdx(c);
            counts[idx]++;
        }

        int left = 0, right = 0;
        int minwindow = 1_000_000, l = -1;
        int tot = n;

        while (right < m) {
            char c = s.charAt(right);
            
            int idx = getCountIdx(c);
            if (counts[idx] > 0) {
                counts[idx]--;
                tot--;
            } else {
                counts[idx]--;
            }

            while (tot == 0) {
                if (right - left + 1 < minwindow) {
                    minwindow = right - left + 1;
                    l = left;
                }
                
                c = s.charAt(left);
                idx = getCountIdx(c);
                counts[idx]++;
                
                if (counts[idx] > 0) {
                    tot++;
                }
                left++;
            }
            right++;
        }

        return l == -1 ? "" : s.substring(l, l + minwindow);
    }

    int getCountIdx(char c) {
        int idx = 0;
        if (c >= 'a'  && c <= 'z') {
            idx = c - 'a';
        } else {
            idx = c - 'A' + 26;
        }
        return idx;
    }
}