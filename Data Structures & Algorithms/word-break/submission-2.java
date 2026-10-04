class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, 0, wordDict, new Boolean[s.length()]);
    }

    boolean wordBreak(String s, int idx, List<String> wordDict, Boolean[] memo) {
        if (idx == s.length()) return true;

        if (memo[idx] != null) return memo[idx];

        for (int i = 0; i < wordDict.size(); i++) {
            String word = wordDict.get(i);
            if (s.startsWith(word, idx) && wordBreak(s, idx + word.length(), wordDict, memo)) {
                memo[idx] = true;
                return true;
            }
        }

        memo[idx] = false;
        return false;
    }
}