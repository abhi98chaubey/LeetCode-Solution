class Solution {
    public List<List<Integer>> generate(int numRows) {
        var triangle = new ArrayList<List<Integer>>(numRows);
        triangle.add(List.of(1)); 
        if(numRows ==1) return triangle; // return it already if only asked until row 1
        triangle.add(List.of(1,1));
        if(numRows ==2) return triangle;  // return it already if only asked until row 2
        
        generate(triangle, new Integer[] {1,1}, 3, numRows); // start from row 3
        
        return triangle;
    }
    
       public void generate(List<List<Integer>> triangle, Integer[] row, int rowCount, int max) {
        var newRow = generateNewRow(row); // generate new row
        triangle.add(List.of(newRow));  // add the new row to the bottom of the triangle
        
        if(rowCount == max) return; // if row counts already meet user's request, return
        generate(triangle, newRow, rowCount+1, max); // else fill up the next row
    }
    
    public Integer[] generateNewRow(Integer[] row) {
        var newRow = new Integer[row.length+1];
        newRow[0] = 1; // the first col is always 1
        newRow[newRow.length-1] = 1; // the last col is always 1
        for(int col=0; col<row.length-1; col++) { // filling up the middle cols
            newRow[col+1] = row[col] + row[col+1]; // which is a sum of two above adjecent cols
        }
                
        return newRow;
    }
}