public class Solution {
    // you need to treat n as an unsigned value
    
    public int hammingWeight(int n) {
        
        //Method Brute Force
        // int-->string
        
        // Method 02:
        
        int counter=0;
        
        while (n!=0){
          counter+= (n & 1);
            n=n>>>1;
        }
        return counter;
    }
}
