class Solution {
    static Map<Character, Character> braces = new HashMap<>();
    static Set<Character> openingBraces = new HashSet<>();
    static {
        braces.put('}', '{');
        braces.put(')', '(');
        braces.put(']', '[');
        openingBraces = braces.values().stream().collect(Collectors.toSet());
    }
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            // System.out.println(c + ": " + stack.toString());
            if (openingBraces.contains(c)) stack.push(c);
            else if (stack.isEmpty() || braces.get(c) != stack.pop()) return false;
        }

        return stack.isEmpty();
    }
}