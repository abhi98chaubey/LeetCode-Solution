class Solution {
    public boolean isValid(String s) {
        String pattern = ")}]";
		Stack<Character> stack = new Stack();

		for(int i=0; i<s.length(); i++){
			if(pattern.contains(String.valueOf(s.charAt(i)))){
				if(stack.isEmpty())
					return false;
				if(stack.peek()=='{' && s.charAt(i)=='}')
					stack.pop();
				else if(stack.peek()=='(' && s.charAt(i)==')')
					stack.pop();
				else if(stack.peek()=='[' && s.charAt(i)==']')
					stack.pop();
				else 
					return false;
			}
			else
				stack.push(s.charAt(i));
		}

		return stack.isEmpty();


	
    }
}