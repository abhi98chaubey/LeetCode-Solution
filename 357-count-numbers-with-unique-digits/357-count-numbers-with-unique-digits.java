class Solution {
   public int countNumbersWithUniqueDigits(int n) {
    if(n==0)return 1;
    int ans=10;
    int curr=9;
    int st=9;
    int i=n;
    while(i>1){
        curr*=st;
        ans+=curr;
        st--;
        i--;
    }
    return ans;
}
}