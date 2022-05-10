class Solution {
    public boolean isUgly(int n) {
        
        if ( n <= 0 ) return false;
        if ( n==1) return true;  
        
        int [] arr = {2,3,5};       
        for ( int i = 0 ; i < 3 ; i++)
        {
            while ( n % arr[i] == 0 && n != 1)
            {
                n = n/arr[i];
                if ( n == 1) return true;
            }
        }
        return false;        
    }
}