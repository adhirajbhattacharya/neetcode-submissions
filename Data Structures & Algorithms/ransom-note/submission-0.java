class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> count = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            count.put(c, 1 + count.getOrDefault(c, 0));
        }

        for (char c : ransomNote.toCharArray()) {
            count.put(c, -1 + count.getOrDefault(c, 0));
        }

        return count.values().stream().filter(i -> i < 0).count() == 0;
    }
}