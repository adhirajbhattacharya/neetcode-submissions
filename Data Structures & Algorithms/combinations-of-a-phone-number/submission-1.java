class Solution {
    static Map<Character, char[]> map;
    static {
        map = new HashMap<>();
        map.put('2', new char[] {'a', 'b', 'c'});
        map.put('3', new char[] {'d', 'e', 'f'});
        map.put('4', new char[] {'g', 'h', 'i'});
        map.put('5', new char[] {'j', 'k', 'l'});
        map.put('6', new char[] {'m', 'n', 'o'});
        map.put('7', new char[] {'p', 'q', 'r', 's'});
        map.put('8', new char[] {'t', 'u', 'v'});
        map.put('9', new char[] {'w', 'x', 'y', 'z'});
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        letterCombinations(digits, 0, new StringBuilder(), result);
        return result;
    }

    void letterCombinations(String digits, int idx, StringBuilder path, List<String> result) {
        if (idx == digits.length()) {
            if (!path.isEmpty()) result.add(path.toString());
            return;
        }

        char digit = digits.charAt(idx);

        for (char c : map.get(digit)) {
            path.append(c);
            letterCombinations(digits, idx + 1, path, result);
            path.setLength(path.length() - 1);
            // path.deleteCharAt(path.length() - 1);
        }
    }
}