class Solution {
    public int largestRectangleArea(int[] heights) {
        // return largestRectangleAreaBySegmentTree(heights);
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

    int largestRectangleAreaBySegmentTree(int[] heights) {
        RangeMinTree st = new Iterative(heights);
        return getMaxArea(st, 0, heights.length - 1, heights);
    }

    int getMaxArea(RangeMinTree st, int start, int end, int[] heights) {
        if  (start > end) return Integer.MIN_VALUE;

        int min = st.getMin(start, end);
        int area = heights[min] * (end - start + 1);

        int leftarea = getMaxArea(st, start, min - 1, heights);
        int rightarea = getMaxArea(st, min + 1, end, heights);

        return Math.max(area, Math.max(leftarea, rightarea));
    }
}

interface RangeMinTree {
    int getMin(int st, int en);
}

class Iterative implements RangeMinTree{
    int[] st;

    Iterative(int[] heights) {
        int n = heights.length;

    }

    public int getMin(int st, int en) {
        return 0;
    }
}
