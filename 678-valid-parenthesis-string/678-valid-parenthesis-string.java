class Solution {
    public boolean checkValidString(String s) {
        //Stack for stars index
        Stack<Integer> star = new Stack<>();
        //Stack for '(' character
        Stack<Integer> paranthesis = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='*')
                star.push(i);
            else if(s.charAt(i) == '(')
                paranthesis.push(i);
            else{
                // if char == ')' always check the ')' first then check for star
                if(paranthesis.isEmpty()){
                    if(star.size() > 0)
                        star.pop();
                    else{
                        return false;
                    }
                }else{
                    paranthesis.pop();
                }
            }
        }
        
        //if parenthesis stack size is greater then is no way we can balance this
        if(paranthesis.size()> star.size())
            return false;
        
        // if star index is less than '(' index there is no way we can balance so simply return false;
        while(paranthesis.size() !=0){
            int i1 = paranthesis.pop();
            int i2 = star.pop();
            if(i1>i2)
                return false;
        }
        return true;
    }
}