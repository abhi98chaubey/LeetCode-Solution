class Solution {
   public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
		
		// for each op, if it contains a minus sign, subtract from ans, else add to ans.
        for (int i = 0; i < operations.length; i++) {
            String op = operations[i];
            if(op.indexOf('-') >=0 ) {
                ans --;
            } else {
                ans ++;
            }
        }
        return ans;
    } 
}