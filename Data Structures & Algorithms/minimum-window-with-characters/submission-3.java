class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tfreq = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tfreq.put(c, tfreq.getOrDefault(c, 0) + 1);
        }

        int tcount = tfreq.size();

        Map<Character, Integer> sfreq = new HashMap<>();
        int minleft = 0, minright = Integer.MAX_VALUE;
        int left = 0, right;
        int seencount = 0;

        for (int i = 0; i < s.length(); i++) {
            right = i;
            char r = s.charAt(right);
            sfreq.put(r, sfreq.getOrDefault(r, 0) + 1);

            if (tfreq.containsKey(r) && tfreq.get(r).equals(sfreq.get(r)))
                seencount++;
            
            while (seencount == tcount) {
                if (right - left < minright - minleft) {
                    minleft = left;
                    minright = right;
                }
                char l = s.charAt(left);
                sfreq.put(l, sfreq.get(l) - 1);
                left++;

                if (tfreq.containsKey(l) && Integer.compare(tfreq.get(l), sfreq.get(l)) == 1)
                    seencount--;
            }
        }
        return minright == Integer.MAX_VALUE ? "" : s.substring(minleft, minright + 1);
    }
}
