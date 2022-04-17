class Solution {
    public void dfs(int x,int y,int[][] grid,int m,int n){
        if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==1){
           grid[x][y] = 0;
           dfs(x+1,y,grid,m,n);
           dfs(x-1,y,grid,m,n);
           dfs(x,y+1,grid,m,n);
           dfs(x,y-1,grid,m,n);
        }
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0 || j==0 || i==m-1 || j==n-1) && grid[i][j]==1){
                    dfs(i,j,grid,m,n);
                }
            }
        }
        int cnt = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                  if(grid[i][j]==1)cnt++;     
            }
        }
        return cnt;
    }
    
}
