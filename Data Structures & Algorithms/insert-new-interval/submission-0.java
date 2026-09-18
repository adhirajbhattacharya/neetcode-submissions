class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if (n == 0) return new int[][] { newInterval };

        List<int[]> merged = new ArrayList<>();
        boolean inserted = false;
        int i = 0;
        while (i < n && !inserted) {
            int j = i;
            while (j < n && isOverlappedIntervals(intervals[j], newInterval)) {
                inserted = true;
                newInterval = mergeIntervals(intervals[j], newInterval);
                j++;
            }

            if (inserted) {
                merged.add(newInterval);
                i = j;
            } else {
                merged.add(intervals[i]);
                i++;
            }
        }

        while (i < n) {
            merged.add(intervals[i]);
            i++;
        }

        if (!inserted) insertIntervalIntoPosition(merged, newInterval);

        return merged.toArray(new int[0][]);
    }

    boolean isOverlappedIntervals(int[] a, int[] b) {
        return (a[0] <= b[0] && a[1] >= b[0]) || (a[0] > b[0] && a[0] <= b[1]);
    }

    int[] mergeIntervals(int[] a, int[] b) {
        return new int[] { Math.min(a[0], b[0]), Math.max(a[1], b[1]) };
    }

    void insertIntervalIntoPosition(List<int[]> intervals, int[] interval) {
        int n = intervals.size();
        if (interval[1] < intervals.get(0)[0]) {
            intervals.add(0, interval);
            return;
        }

        if (interval[0] > intervals.get(n - 1)[1]) {
            intervals.add(interval);
            return;
        }

        for (int i = 1; i < n; i++) {
            if (interval[0] > intervals.get(i)[1]) continue;
            intervals.add(i, interval);
            break;
        }
    }
}