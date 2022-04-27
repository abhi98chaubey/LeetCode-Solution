class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    numIslands_(grid,i,j);
                }
            }
        }
        
        return count;
    }
    
    public void numIslands_(char [][]grid,int i, int j){
        if(grid[i][j]=='1'){
            grid[i][j]='0';
        }
        
        int [][]dir={{0,-1},{1,0},{-1,0},{0,1}};
        
        for(int k=0;k<4;k++){
            int x=i+dir[k][0];
            int y=j+dir[k][1];
            
            if(posCheck(x,y,grid)){
                numIslands_(grid,x,y);
            }   
        }
    }
    
    public boolean posCheck(int x,int y,char [][]grid){
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y]=='0'){
            return false;
        }
        
        return true;
    }
}