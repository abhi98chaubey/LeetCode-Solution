class Solution {
    public int tribonacci(int n) {
         int first=0;
    int second=1;
    int third=1;
    if(n==0)
        return 0;
    if(n==1)
        return 1;
    if(n==2)
        return 1;
    int fourth=0;
    
    for(int i=3;i<=n;i++){
        fourth=first+second+third;
        first=second;
        second=third;
        third=fourth;
    }
    return fourth;
}
        
    }
