class Solution {
    HashSet<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<String>();
        return dfs(s, wordDict);
    }
    
    public boolean dfs(String s, List<String> wordDict) {
        if(s.equals("")){
            return true;
        }
        if(set.contains(s)){
            return false;
        }
        
        for(String word : wordDict){
            if(s.startsWith(word)){
                String suffix = s.substring(word.length());
                if (dfs(suffix, wordDict)){
                    return true;
                }
            }
        }
        set.add(s);
        return false;
    }
}