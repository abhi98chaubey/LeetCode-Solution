class Solution {
    Map<String, Boolean> t = new HashMap<String, Boolean>();
public boolean isScramble(String s1, String s2) {
    
     if(s1.length() != s2.length()){
        return false;
    }
    
    return solve(s1, s2);       
    
}


public boolean solve(String s1, String s2){
    
   
    if(s1.length() == 0 && s2.length() == 0){
        return true;
    }
    if(s1.equals(s2)){
        return true;
    }
    
           
    if(t.get(getKey(s1,s2)) != null){
        return t.get(getKey(s1,s2));
    }
    
    int n = s1.length();
    boolean flag = false;
    
    for(int i = 1; i < n ; i++){
        if((solve(s1.substring(0,i), s2.substring(n-i, n)) == true && solve(s1.substring(i,n), s2.substring(0, n-i)) == true) 
          || (solve(s1.substring(0,i), s2.substring(0, i)) == true && solve(s1.substring(i,n), s2.substring(i,n)) == true)){
            flag = true;
            break;
        }
    }
    t.put(getKey(s1,s2), flag);
    return flag;
    
    
    
}

public String getKey(String a, String b){
    return a + "_" + b;
}
}