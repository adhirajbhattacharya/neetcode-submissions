class Solution {
    int[] dir = {-1, 0, 1, 0, -1};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int l = word.length();

        if (l > m * n) return false;

        boolean found = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j]) {
                    found = found || dfs(board, i, j, m - 1, n - 1, word, 0);
                    if (found) return true;
                }
            }
        }

        return found;
    }

    boolean dfs(char[][] board, int row, int col, int rowmax, int colmax, String word, int idx) {
        if (board[row][col] == '#') return false;
        if (board[row][col] != word.charAt(idx)) return false;
        if (idx == word.length() - 1) return true;

        char orig = board[row][col];
        board[row][col] = '#';
        boolean found = false;

        for (int i = 0; i < dir.length - 1; i++) {
            int r = row + dir[i];
            int c = col + dir[i + 1];
            if (r < 0 || c < 0 || r > rowmax || c > colmax) continue;
            found = found || dfs(board, r, c, rowmax, colmax, word, idx + 1);
            if (found) return true;
        }
        board[row][col] = orig;
        return found;
    }
}