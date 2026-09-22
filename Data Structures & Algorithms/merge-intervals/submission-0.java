class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n == 1) return intervals;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int merges = 0;
        int[] dummy = new int[] {-1, -1};
        for (int i = 1; i < n; i++) {
            int[] prev = intervals[i - 1];
            int[] curr = intervals[i];
            if(isOverlappingIntervals(prev, curr)) {
                intervals[i - 1] = dummy;
                intervals[i] = mergeIntervals(prev, curr);
                merges++;
            }
        }
        int[][] res = new int[n - merges][];

        System.out.println(n -merges);
        System.out.println(Arrays.deepToString(intervals));

        for (int i = 0, j = 0; i < n; i++) {
            if (Arrays.equals(intervals[i], dummy)) continue;
            res[j] = intervals[i];
            j++;
        }

        return res;
    }

    boolean isOverlappingIntervals(int[] a, int[] b) {
        return !(a[1] < b[0] || b[1] < a[0]);
    }

    int[] mergeIntervals(int[] a, int[] b) {
        return new int[] { Math.min(a[0], b[0]), Math.max(a[1], b[1]) };
    }
}