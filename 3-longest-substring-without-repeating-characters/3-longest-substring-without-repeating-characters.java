class Solution {
    public int lengthOfLongestSubstring(String s) {
        List<Character> list = new ArrayList<>();
        int op = 0;
        for(int i =0;i<s.length();i++){
            char curr = s.charAt(i);
            if(list.contains(curr)){
                while(list.contains(curr)) list.remove(0);
            }
            list.add(curr);
            op = Math.max(op,list.size());
        }
        return op;
    }
}