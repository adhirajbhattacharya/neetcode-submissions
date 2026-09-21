class Solution {
    int[][] dir = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Deque<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                }
            }
        }

        int count = 0;
        q.offer(new int[] {-1, -1});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            if (curr[0] == -1) {
                if (!q.isEmpty()) {
                    count++;
                    q.offer(curr);
                }
                continue;
            }

            for (int[] d : dir) {
                int r = curr[0] + d[0];
                int c = curr[1] + d[1];

                if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] != 1) continue;
                grid[r][c] = 2;
                q.offer(new int[] {r, c});
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count = -1;
                }
            }
        }

        return count;
    }
}