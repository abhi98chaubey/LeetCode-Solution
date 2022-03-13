class Solution {
    
    private boolean[][] rowCount = new boolean[9][9];
    private boolean[][] columnCount = new boolean[9][9];
    private boolean[][] blockCount = new boolean[9][9];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c >= '0' && c <= '9') {
                    int t = c - '1';
                    rowCount[i][t] = true;
                    columnCount[j][t] = true;
                    blockCount[getBlockIndex(i, j)][t] = true;
                }
            }
        }

        doInsert(board, 0);
    }

    public boolean doInsert(char[][] board, int index) {
        if (index == 81) return true;
        int row = index / 9;
        int column = index % 9;
        if (board[row][column] == '.') {
            for (int k = 0; k < 9; k++) {
                if (rowCount[row][k] == false) {
                    if (checkBoard(board, row, column, k + 1)) {
                        board[row][column] = Character.forDigit(k + 1,10);
                        rowCount[row][k] = true;
                        columnCount[column][k] = true;
                        blockCount[getBlockIndex(row, column)][k] = true;
                        if (doInsert(board, index + 1)) {
                            return true;
                        } else {
                            board[row][column] = '.';
                            rowCount[row][k] = false;
                            columnCount[column][k] = false;
                            blockCount[getBlockIndex(row, column)][k] = false;
                        }
                    }
                }
            }
            board[row][column] = '.';
            return false;
        } else {
            return doInsert(board, index + 1);
        }
    }
    
    public boolean checkBoard(char[][] board, int row, int column, int num) {
        if (rowCount[row][num - 1] || columnCount[column][num - 1] ||
                blockCount[getBlockIndex(row, column)][num - 1]) {
            return false;
        } else {
            return true;
        }
    }

    public int getBlockIndex(int row, int column) {
        return row / 3 * 3 + column / 3;
    }
}