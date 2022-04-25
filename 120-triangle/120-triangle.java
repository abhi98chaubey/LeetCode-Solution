class Solution {
    
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();
        for(List<Integer> row : triangle) {
            dp.add(new ArrayList<>());
        }
        return helper(triangle, 0, 0, dp);
    }
    
    private int helper(List<List<Integer>> triangle, int rowIdx, int colIdx, List<List<Integer>> dp) {
        if(rowIdx >= triangle.size() || colIdx == triangle.get(rowIdx).size()) return 0;

        if(dp.get(rowIdx).size() <= colIdx) {
            int adjacent = triangle.get(rowIdx).get(colIdx) + helper(triangle, rowIdx + 1, colIdx, dp);
            int adjacentPlusOne = triangle.get(rowIdx).get(colIdx) + helper(triangle, rowIdx + 1, colIdx + 1, dp);
            
            dp.get(rowIdx).add(Math.min(adjacent, adjacentPlusOne));
        }

        
        return dp.get(rowIdx).get(colIdx);
    }
}