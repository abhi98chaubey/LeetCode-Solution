class Solution {
    public int[][] findFarmland(int[][] land) {
        List<int[]> result = new ArrayList<>();
        
        for(int i = 0; i < land.length; i++) {
            for(int j = 0; j < land[0].length; j++) {
                if(land[i][j] == 1) {
                    int[] list = new int[4];
                    list[0] = i;
                    list[1] = j;
                    dfs(land, i, j, list);
                    result.add(list);
                }
            }
        }
        return result.toArray(new int[0][]);
    }
    
    public void dfs(int[][] land, int x, int y, int[] list) {
        if(!isValid(land, x, y)) return;
        
        land[x][y] = 0;
        
        dfs(land, x + 1, y, list);
        dfs(land, x, y + 1, list);
        
        list[2] = Math.max(list[2], x);
        list[3] = Math.max(list[3], y);
    }
    
    public boolean isValid(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] != 0;
    }
}