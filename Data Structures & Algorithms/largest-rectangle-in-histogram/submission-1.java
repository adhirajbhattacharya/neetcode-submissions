class Solution {
    public int largestRectangleArea(int[] heights) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int maxarea = 0;

        for (int i = 0; i < heights.length; i++) {
            if (stack.isEmpty()) {
                stack.addLast(i);
            }
            int currheadidx = stack.peekLast();
            if (heights[i] < heights[currheadidx]) {
                while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {
                    int popheadidx = stack.removeLast();
                    int newheadidx = stack.isEmpty() ? -1 : stack.peekLast();
                    maxarea = Math.max(maxarea, heights[popheadidx] * (currheadidx - newheadidx));
                }
            }
            stack.addLast(i);
        }

        int currheadidx = stack.isEmpty() ? 0 : stack.peekLast();
        while (!stack.isEmpty()) {
            int popheadidx = stack.removeLast();
            int newheadidx = stack.isEmpty() ? -1 : stack.peekLast();
            maxarea = Math.max(maxarea, heights[popheadidx] * (currheadidx - newheadidx));
        }
        return maxarea;
    }
}
