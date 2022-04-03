class Solution {
     public List<String> stringMatching(String[] words) {
       List<String> al =new ArrayList<>();
        for(String s:words){
            for(String ss:words){
                if(ss.contains(s) && !ss.equals(s)){
                    al.add(s);
                    break;
                }
            }
        }
        return al;
    }
}