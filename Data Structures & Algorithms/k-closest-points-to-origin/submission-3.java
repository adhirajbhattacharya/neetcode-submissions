class Solution {
    OriginDistanceComparator comp = new OriginDistanceComparator();
    public int[][] kClosest(int[][] points, int k) {
        // return kClosestPq(points, k);
        return kClosestQuickSelect(points, 0, points.length - 1, k);
    }

    int[][] kClosestPq(int[][] points, int k) {
        Queue<int[]> pq = new PriorityQueue<>(new OriginDistanceComparator().reversed());

        for (int i = 0; i < points.length; i++) {
            pq.offer(points[i]);
            if (pq.size() > k) pq.poll();
        }

        int[][] result = new int[k][2];
        int i = 0;

        while (!pq.isEmpty()) {
            result[i] = pq.poll();
            i++;
        }

        return result;
    }

    int[][] kClosestQuickSelect(int[][] points, int st, int en, int k) {
        if (st >= en) return Arrays.copyOfRange(points, 0, k);

        int p = partition(points, st, en);

        if (p == k) return Arrays.copyOfRange(points, 0, p);

        return p > k ? kClosestQuickSelect(points, st, p - 1, k) : kClosestQuickSelect(points, p + 1, en, k);
    }

    int partition(int[][] points, int st, int en) {
        int pivot = st + (en - st) / 2;
        swap(points, st, pivot);

        int[] cmp = points[st];
        int i = st + 1, j = en;

        while (i <= j) {
            if (comp.compare(points[i], cmp) <= 0) {
                i++;
            } else {
                swap(points, i, j);
                j--;
            }
        }

        swap(points, i - 1, st);
        return i - 1;
    }

    void swap(int[][] arr, int x, int y) {
        int[] tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}

class OriginDistanceComparator implements Comparator<int[]> {
    public int compare(int[] a, int[] b) {
        int distance_a = a[1] * a[1] + a[0] * a[0];
        int distance_b = b[1] * b[1] + b[0] * b[0];

        if (distance_a == distance_b) return 0;
        if (distance_a < distance_b) return -1;
        return 1;
    }
}