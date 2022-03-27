class Solution {
    public boolean checkIfPangram(String str) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=97 ; i<=122 ; i++){
            char cc=(char) i;
            map.put(cc,0);
        }
        for(int i=0 ; i<str.length() ; i++){
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
        
        }
        for(Map.Entry<Character,Integer> e:map.entrySet()){
            if(e.getValue()<1){
                return false;
            }
        }
        return true;
    }
}