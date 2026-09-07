class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> valsInRow = new HashMap<>();
        Map<Integer, Set<Character>> valsInCol = new HashMap<>();
        Map<Integer, Set<Character>> valsInSq = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            valsInRow.put(i, new HashSet<>());
            valsInCol.put(i, new HashSet<>());
            valsInSq.put(i, new HashSet<>());
        }
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char val = board[i][j];
                if (val == '.') continue;

                int row = i;
                int col = j;
                int sq = (3 * (i / 3)) + j / 3;

                Set<Character> rowVals = valsInRow.get(row);
                Set<Character> colVals = valsInCol.get(col);
                Set<Character> sqVals = valsInSq.get(sq);

                if (rowVals.contains(val) || colVals.contains(val) || sqVals.contains(val)) return false;
                rowVals.add(val);
                colVals.add(val);
                sqVals.add(val);
            }
        }

        return true;
    }
}
