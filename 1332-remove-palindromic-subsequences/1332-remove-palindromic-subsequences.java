class Solution {
    public int removePalindromeSub(String s) {
        //we are dealing with only 'a' and 'b'
        //if the whole string is a palindrome -> 1
        //else remove 'a' and 'b' -> 1+1 -> 2
        
        if(isPalindrome(s))
            return 1;
        
        return 2;
    }
    
    private boolean isPalindrome(String s){
        int n = s.length();
        for(int i=0;i<n/2;i++){
            char c1 = s.charAt(i);
            char c2 = s.charAt(n-i-1);
            
            if(c1 != c2)
                return false;
        }
        
        return true;
    }
}