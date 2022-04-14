class Solution {

    int[][] nexts=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public int[][] highestPeak(int[][] isWater) {
        
        int m=isWater.length;
        int n=isWater[0].length;
        
        boolean[][] visited=new boolean[m][n];
        Queue<int[]> q=new LinkedList<>();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {

                if(isWater[i][j]==0) continue;    

                q.add(new int[]{i,j});
                visited[i][j]=true;
                isWater[i][j]=0;

            }
        }
        
        while(!q.isEmpty()) {
            
            int[] cell=q.poll();
            int r=cell[0], c=cell[1], val=isWater[r][c];
            
            for(int[] next:nexts) {

                int x=r+next[0];
                int y=c+next[1];
                
                if(!isValid(x,y,m,n) || visited[x][y]) continue;
                
                isWater[x][y]=val+1;
                visited[x][y]=true;
                q.add(new int[]{x,y});
            }
            
        }
        
        return isWater;
        
    }
    
    boolean isValid(int r, int c, int m, int n) {
        return r>=0 && r<m && c>=0 && c<n;
    }
}