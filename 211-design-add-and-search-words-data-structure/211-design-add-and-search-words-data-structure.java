class WordDictionary {

   private WordDictionary[] characters;
    private boolean terminates;

    public WordDictionary() {
        characters = new WordDictionary[26];
    }
    
    public void addWord(String word) {
        WordDictionary current = this;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            
            current = current.insert(c);
        }
        
        current.terminates = true; //This is the last character in the word. Mark the node as terminates.
    }
    
    public boolean search(String word) {
        if(word.length() <= 0) return true;
        
        return searchHelper(word, 0);
    }
    
    private boolean searchHelper(String word, int wordCharIdx) {
        if(wordCharIdx >= word.length()) return false;
        
        char c = word.charAt(wordCharIdx);
        
        if(c == '.') {
            for(int charIdx = 0; charIdx < characters.length; charIdx++) {
                WordDictionary forChar = characters[charIdx];
                if(forChar == null) continue;

                //Make sure it is a full word and not a prefix.
                if((wordCharIdx >= word.length() - 1 && forChar.terminates) || forChar.searchHelper(word, wordCharIdx + 1)) return true;
            }
        } else {
            int charIdx = c - 'a'; //Gives the index of a lower case letter starting at 0 in a-z.

            WordDictionary forChar = characters[charIdx];
            if(forChar == null) return false;

            //Make sure it is a full word and not a prefix.
            if(wordCharIdx >= word.length() - 1) return forChar.terminates;
            
            return forChar.searchHelper(word, wordCharIdx + 1);
        }
        
        return false;
    }
    
    private WordDictionary insert(char c) {
        int charIdx = c - 'a'; //Gives the index of a lower case letter starting at 0 in a-z.
        
        if(characters[charIdx] == null) characters[charIdx] = new WordDictionary();
        
        return characters[charIdx];
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */