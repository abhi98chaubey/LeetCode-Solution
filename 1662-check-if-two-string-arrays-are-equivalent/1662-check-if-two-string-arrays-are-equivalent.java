class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder b1 = new StringBuilder(), b2 = new StringBuilder();
        
        for (String s: word1) b1.append(s);
        for (String s: word2) b2.append(s);
        
        return b1.toString().equals(b2.toString());
    }
}