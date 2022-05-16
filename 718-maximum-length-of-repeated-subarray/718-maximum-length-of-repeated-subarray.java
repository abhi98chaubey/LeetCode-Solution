class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int res =0;
int memo[][] = new int[nums1.length][nums2.length];
for(int i=0;i<nums1.length;i++){
for(int j =0;j<nums2.length;j++){
if(nums1[i]==nums2[j]){
if(i==0 || j==0)memo[i][j]=1;
else memo[i][j]=memo[i-1][j-1]+1;
res = Math.max(res,memo[i][j]);
}
}
}
return res;
    }
}