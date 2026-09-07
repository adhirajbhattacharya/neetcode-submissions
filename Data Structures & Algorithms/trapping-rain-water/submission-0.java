class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int maxL = height[l], maxR = height[r];
        int water = 0;

        while (l != r) {
            System.out.println("---------------------------------------");
            System.out.println("maxL -> " + maxL + ", maxR -> " + maxR);
            System.out.println("l -> " + l + ", r -> " + r);
            if (maxL <= maxR) {
                l++;
                int h = height[l];
                water += Math.max(0, maxL - h);
                maxL = Math.max(maxL, h);
            } else {
                r--;
                int h = height[r];
                water += Math.max(0, maxR - h);
                maxR = Math.max(maxR, h);
            }
        }
        return water;
    }
}
