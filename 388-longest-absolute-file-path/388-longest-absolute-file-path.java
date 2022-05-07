class Solution {
    public int lengthLongestPath(String input) {
        List<Integer> lengths = new ArrayList<>();
        
        int counter = 0, len = input.length(), result = 0, tab = 0;
        boolean file = false;
        
        for(int i = 0; i < len; i++) {
            char ch = input.charAt(i);
            
            if(ch == '\t') {
                tab++;
            }
            else if(ch != '\n') {
                counter++;
                
                if(ch == '.') {
                    file = true;
                }
            }
                        
            if(ch == '\n' || i == len - 1) {
                int pathLen = counter;
                if(tab != 0) {
                    pathLen += lengths.get(tab - 1);
                }
                
                if(file) {
                    result = Math.max(result, pathLen);
                    file = false;
                }
                
                pathLen++;
                
                if(lengths.size() == tab) lengths.add(pathLen);
                else lengths.set(tab, pathLen);
                
                counter = 0;
                tab = 0;
            }
        }
        
        return result;
    }
}