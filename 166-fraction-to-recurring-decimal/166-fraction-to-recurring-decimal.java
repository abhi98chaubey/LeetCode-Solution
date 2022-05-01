class Solution {
    public String fractionToDecimal(int n, int d) {
        StringBuilder ans = new StringBuilder();
             long num = n;
              long den = d;
              
            long r = num % den;
            long q = num / den;
            ans.append(q);
            
            if(r == 0){
                return ans.toString();
            }else{
                ans.append(".");
                HashMap<Long,Long> map= new HashMap<>();
                while(r!=0){
                if(map.containsKey(r)){
                    long len = map.get(r);
                    ans.insert((int)len,"(");
                    ans.append(")");
                    break;
                }
                    
                else{
                    map.put(r,(long)ans.length());
                    r *= 10;
                    q = Math.abs((r / den));
                    r = r % den;
                    ans.append(q);
                }    
                    
                }
                
                
                
            
            }
        if(num < 0 || den < 0)ans.insert(0,"-");
        if(num<0)ans.deleteCharAt(0);
        
        return ans.toString();
    }
}