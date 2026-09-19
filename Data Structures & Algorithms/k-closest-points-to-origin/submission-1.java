class Solution {
    public int[][] kClosest(int[][] points, int k) {
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