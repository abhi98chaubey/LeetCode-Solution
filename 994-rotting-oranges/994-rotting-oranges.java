class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int minutes = 0;
        if (allrotten(grid)){
            return 0;
        }
        class Pair{
           int row;
           int col;
           int minutes;
          public Pair(int r, int c, int m){
              row = r;
              col = c;
              minutes = m;
          }
        }
        Queue<Pair> queue = new LinkedList<>();
        for(int i = 0; i< m; i++){
            for (int j = 0; j< n; j++){
                if(grid[i][j] == 2) {
                    queue.add(new Pair(i, j, 0));
                }
            }
        }
        while(!queue.isEmpty()){
            Pair p = queue.remove();
            if(p.minutes > minutes){
                minutes = p.minutes;
            }
            if(p.row - 1  >= 0 && grid[p.row - 1][p.col] == 1){
                grid[p.row-1][p.col] = 2;
               queue.add(new Pair(p.row-1, p.col, p.minutes+1));
            }
            if(p.row + 1 < m && grid[p.row + 1][p.col] == 1){
                grid[p.row + 1][p.col] = 2;
                queue.add(new Pair(p.row+1, p.col, p.minutes+1));
            }
            if(p.col - 1  >= 0 && grid[p.row][p.col-1] == 1){
                grid[p.row ][p.col-1] = 2;
                queue.add(new Pair(p.row, p.col-1, p.minutes+1));
            }
             if(p.col + 1  < n && grid[p.row][p.col+1] == 1){
                grid[p.row ][p.col+1] = 2;
                queue.add(new Pair(p.row, p.col+1, p.minutes+1));
            }
            
        }
        if (allrotten(grid)){
            return minutes;
        }else{
            return -1;
        }
        
    }
    public boolean allrotten(int [][]grid){
        for(int i = 0 ;i < grid.length; i++){
            for(int j = 0 ; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    return false;
                }
            }
        }
        return true;
    }
}