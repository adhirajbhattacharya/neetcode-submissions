class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        int[][] rows = new int[n][n + 1];
        int[][] cols = new int[n][n + 1];
        int[][] boxes = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                
                int val = Character.getNumericValue(c);
                
                if (rows[i][val] == 1) return false;
                rows[i][val] = 1;

                if (cols[j][val] == 1) return false;
                cols[j][val] = 1;

                if (boxes[(i / 3) * 3 + (j / 3)][val] == 1) return false;
                boxes[(i / 3) * 3 + (j / 3)][val] = 1;
            }
        }
        return true;
    }
}