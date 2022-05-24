class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int max = 0;
        
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '('){
                st.push(i);
            }
            else{
                st.pop();
                if(!st.isEmpty()){   //stack not empty means we have found the opening pair
                    max = Math.max(max,i - st.peek());
                }
                else{    //stack is empty means there is no opening pair
                    st.push(i);
                }
            }
        }
        return max;
    }
}