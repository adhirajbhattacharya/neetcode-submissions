class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;

        int maxarea = Integer.MIN_VALUE;
        while (l < r) {
            int lHt = height[l];
            int rHt = height[r];

            if (lHt < rHt) {
                maxarea = Math.max(maxarea, lHt * (r - l));
                l++;
            } else {
                maxarea = Math.max(maxarea, rHt * (r - l));
                r--;
            }
        }
        return maxarea;
    }
}