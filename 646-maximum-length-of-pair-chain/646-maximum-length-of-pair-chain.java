class Solution {
    private int rec(int i,int prev,int arr[][],int dp[][]){
        if(i==arr.length)
            return 0;
        if(dp[i][prev]!=-1)
            return dp[i][prev];
        dp[i][prev]=rec(i+1,prev,arr,dp);
        if(arr[i][0]>arr[prev][1])
            dp[i][prev]=Math.max(dp[i][prev],1+rec(i+1,i,arr,dp));
        return dp[i][prev];
    }
    public int findLongestChain(int[][] pairs) {
        int dp[][]=new int[pairs.length][pairs.length];
        for(int mid[]:dp)
            Arrays.fill(mid,-1);
        Arrays.sort(pairs,(a,b)->(a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));
        int result=1;
        for(int i=0;i<pairs.length-1;i++)
            result=Math.max(result,1+rec(i+1,i,pairs,dp));
        return result;
    }
}