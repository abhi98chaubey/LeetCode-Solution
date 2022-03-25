class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] ver = new int[m][n];
        int[][] hor = new int[m][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[j][i] == 1) {
                    ver[j][i] = j == 0 ? ver[j][i] = 1 : ver[j-1][i] + 1;   
                } else {
                    ver[j][i] = 0;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    hor[i][j] = j == 0 ? hor[i][j] = 1 : hor[i][j-1] + 1;
                } else {
                    hor[i][j] = 0;
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                boolean found = false;
                for (int len = Math.min(ver[i][j], hor[i][j]); len > max && !found; len--) {
                    
                    if (ver[i][j+1-len] >= len && hor[i+1-len][j] >= len) {
                        max = len;
                        found = true;
                    }
                }
            }
        }
        
        return max * max;
    }
}