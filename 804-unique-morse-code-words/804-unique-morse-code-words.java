class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for (String word: words){
            StringBuilder morse = new StringBuilder();
            for (char c: word.toCharArray()){
                morse.append(codes[c - 'a']);
            }
            set.add(morse.toString());
        }
        return set.size();
    }
}