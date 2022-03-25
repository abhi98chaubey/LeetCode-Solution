class Solution {
    public boolean isSubsequence(String s, String t) {
        int s1=s.length()-1;
        int t1=t.length()-1;
        while(t1>=0 && s1>=0){
            if(s.charAt(s1)==t.charAt(t1))
                s1--;
            t1--;
        }
        return s1<0;
    }
}