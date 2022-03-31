class Solution {
    public String truncateSentence(String s, int k) {
        int wordCount = 0;
        String result = s;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ' '){
                wordCount+=1;
            }
            if(wordCount==k) {
             result = s.substring(0,i);
             break;
            }
        }
        return result;
    }
}