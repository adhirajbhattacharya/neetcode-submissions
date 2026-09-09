class Solution {
    public int largestRectangleArea(int[] heights) {
        return largestRectangleAreaByStack(heights);
    }

    int largestRectangleAreaByStack(int[] heights) {
        int n = heights.length;

        int[] leftmin = new int[n];
        int[] rightmin = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }

            while (!stack.isEmpty() && heights[i] < heights[stack.peekFirst()]) {
                int idx = stack.pop();
                rightmin[idx] = i;
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int idx = stack.pop();
            rightmin[idx] = n;
        }

        stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }

            while (!stack.isEmpty() && heights[i] < heights[stack.peekFirst()]) {
                int idx = stack.pop();
                leftmin[idx] = i;
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int idx = stack.pop();
            leftmin[idx] = -1;
        }

        int maxarea = -1;

        for (int i = 0; i < n; i++) {
            int area = heights[i] * (rightmin[i] - leftmin[i] - 1);
            maxarea = Math.max(maxarea, area);
        }

        return maxarea;
    }
}
