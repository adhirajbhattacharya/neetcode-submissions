class Solution {
    static final int[][] DIR = new int[][] {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;

        if (image[sr][sc] == color) return image;
        
        fill(image, sr, sc, color);
        return image;
    }

    void fill(int[][] image, int row, int col, int color) {
        int m = image.length;
        int n = image[0].length;

        int orig_color = image[row][col];
        image[row][col] = color;

        for (int i = 0; i < DIR.length; i++) {
            int adj_row = row - DIR[i][0];
            int adj_col = col - DIR[i][1];
            if (adj_row < 0 || adj_col < 0 || adj_row >= m || adj_col >= n) continue;
            if (image[adj_row][adj_col] == orig_color) fill(image, adj_row, adj_col, color);
        }
    }
}