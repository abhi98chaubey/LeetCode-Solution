class Solution {
    public long numberOfWays(String s) {
        int n = s.length();
        char[] ch = s.toCharArray();
        int zeros = 0;
        int ones = 0;
        long ends_with_0 = 0;
        long ends_with_1 = 0;
        long ans= 0;
        for(int i=0;i<n;i++){
            if(ch[i] == '1'){
                if(i> 1) ans+=ends_with_0;
                if(i> 0) ends_with_1+=zeros;
                ones++;
            } else{
                if(i> 1) ans+=ends_with_1;
                if(i> 0) ends_with_0+=ones;
                zeros++;
            }
        }
        
        return ans;
    }
    
}