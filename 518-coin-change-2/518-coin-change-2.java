class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length][amount+1];
        for (int[] row: dp)
            Arrays.fill(row, -1);
        return helper(amount, coins, coins.length-1, dp);
    }
    
    //a -> amount, c -> coins[], i -> index, dp -> dp array
    public int helper(int a, int c[], int i, int dp[][]){
        // Base condition
        if(i == 0){
            if(a%c[i] == 0){
                return 1;
            }else return 0;
        }
        
        if(dp[i][a] != -1) return dp[i][a];
        int ns = helper(a,c,i-1, dp);
        int s = 0;
        if(a>=c[i]) s = helper(a-c[i],c, i, dp);
        return dp[i][a] = s+ns;
    }
}