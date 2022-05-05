class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1){
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0,0,1});
        int[][] dir = new int[][] {{1,0},{0,1},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1},{0,-1}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                int step = cur[2];
                if(x == m-1 && y == n-1){
                    return step;
                }
                for(int j = 0; j < 8; j++){
                    int newX = x + dir[j][0];
                    int newY = y + dir[j][1];
                    if(newX < 0 || newY < 0 || newX >= m || newY >= n ||grid[newX][newY]==1){
                        continue;
                    }else{
                        grid[newX][newY] = 1;
                        q.offer(new int[] {newX, newY, step+1});
                    }
                }
            }
        }
        return -1;
    }
}