class Solution {
    static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    private void explore(char[][] board, boolean[][] mark, int row, int col) {
        if (board[row][col] != 'O')
            return;
        
        mark[row][col] = true;
        
        for (var dir : dirs) {
            if (row + dir[0] >= 0 && row + dir[0] < board.length &&
               col + dir[1] >= 0 && col + dir[1] < board[0].length &&
               !mark[row + dir[0]][col + dir[1]])
                explore(board, mark, row + dir[0], col + dir[1]);
        }
    }
    
    public void solve(char[][] board) {
        boolean[][] mark = new boolean[board.length][board[0].length];
        
        // Run dfs starting from all 'O' cells on the border
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (i == 0 || i == board.length-1 ||
                   j == 0 || j == board[0].length-1)
                    explore(board, mark, i, j);
            }
        }
        
        // Flip marked cells
        for (int i=1; i<board.length-1; i++) {
            for (int j=1; j<board[0].length-1; j++) {
                if (board[i][j] == 'O' && !mark[i][j])
                    board[i][j] = 'X';
            }
        }
    }
}