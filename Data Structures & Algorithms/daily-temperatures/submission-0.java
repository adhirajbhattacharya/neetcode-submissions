class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = temperatures.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }

            int temp = temperatures[i];
            if (temp <= temperatures[stack.peekFirst()]) {
                stack.push(i);
                continue;
            }

            while (!stack.isEmpty() && temp > temperatures[stack.peekFirst()]) {
                int curr = stack.pop();
                result[curr] = i - curr;
            }
            stack.push(i);
        }

        return result;
    }
}