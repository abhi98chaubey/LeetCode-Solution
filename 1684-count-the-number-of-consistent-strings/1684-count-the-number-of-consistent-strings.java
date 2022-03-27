class Solution {
     public int countConsistentStrings(String allowed, String[] words) {

        int result=0;
        boolean contains=true;
        Set<Character> charSet=new HashSet<>();
        for(int i=0;i<allowed.length();i++){
            charSet.add(allowed.charAt(i));
        }
        for(String word:words){
            contains=true;
            for(int i=0;i<word.length();i++){
               if(charSet.contains(word.charAt(i))==false){
                   contains=false;
                   break;
               }
            }
            if(contains){
                result++;
                
            }
        }

        return result;
    }
}