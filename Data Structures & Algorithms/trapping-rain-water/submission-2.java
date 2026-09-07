class Solution {
    public int trap(int[] heights) {
        // return trapUsingPrefixSum(heights);
        return trapUsingTwoPointers(heights);
    }

    int trapUsingTwoPointers(int[] heights) {
        int n = heights.length;

        int l = 0;
        int r = n - 1;
        int maxLeft = heights[l];
        int maxRight = heights[r];

        int trap = 0;
        while (l < r) {
            int left = heights[l];
            int right = heights[r];
            maxLeft = Math.max(maxLeft, left);
            maxRight = Math.max(maxRight, right);
            int h = Math.min(maxLeft, maxRight);
            if (left < right) {
                trap += Math.max(h - left, 0);
                l++;
            } else {
                trap += Math.max(h - right, 0);
                r--;
            }
        }

        return trap;
    }

    int trapUsingPrefixSum(int[] heights) {
        int n = heights.length;
        int[] highestTillNowPrefix = new int[n];
        int[] highestTillNowSuffix = new int[n];

        highestTillNowPrefix[0] = heights[0];
        highestTillNowSuffix[n - 1] = heights[n - 1];

        int i = 1;
        while (i < n) {
            highestTillNowPrefix[i] = Math.max(highestTillNowPrefix[i - 1], heights[i]);
            highestTillNowSuffix[n - i - 1] = Math.max(highestTillNowSuffix[n - i], heights[n - i - 1]);
            i++;
        }

        System.out.println(Arrays.toString(highestTillNowPrefix));
        System.out.println(Arrays.toString(highestTillNowSuffix));

        int rain = 0;
        i = 0;
        while (i < n) {
            int curr = Math.min(highestTillNowPrefix[i], highestTillNowSuffix[i]) - heights[i];
            rain += curr;//Math.max(curr, 0);
            i++;
        }
        return rain;
    }
}