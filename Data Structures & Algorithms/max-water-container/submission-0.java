class Solution {
    public int maxArea(int[] heights) {
        int i = 0, j = heights.length - 1;
        int maxArea = 0;
        while (i < j) {
            int left = heights[i];
            int right = heights[j];
            int height = Math.min(left, right);
            int width = j - i;
            maxArea = Math.max(maxArea, height * width);

            if (left < right) i++;
            else j--;
        }
        return maxArea;
    }
}
