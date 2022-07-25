class Solution {
    public char repeatedCharacter(String s) {
	//let ans be first character for now
        char ans =s.charAt(0);
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
			//Assigning the frequency of the character in the map created
            map.put(ch, map.getOrDefault(ch, 0) +1);
			
			//finally once the character's frequency exceeds from 1 store it in the ans 
			//character variable created and break from the loop ans finally return the ans
			
            if(map.get(ch) >1){
                ans = ch;
                break;
            }
        }
        return ans;
    }
}