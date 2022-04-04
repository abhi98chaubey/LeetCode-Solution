class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> rows = new HashSet();
        Set<Integer> cols = new HashSet();
        
        for(int i=0; i < m; i++){
            for(int j=0 ; j< n ;j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        setRowsToZero(rows, matrix);
        setColsToZero(cols, matrix);
    }
    
    private void setRowsToZero(Set<Integer> rows, int[][] matrix){
        for(Integer row : rows){
            for(int j=0; j < matrix[0].length; j++){
                matrix[row][j] =0;
            }
        }
    }
    
    private void setColsToZero(Set<Integer> cols, int[][] matrix){
        for(Integer col : cols){
            for(int i =0; i<matrix.length; i++){
                matrix[i][col] = 0;
            }
        }
    }
    
}