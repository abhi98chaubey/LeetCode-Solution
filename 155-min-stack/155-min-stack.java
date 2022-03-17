

class MinStack {

    class Pair{
        int val;
        int min;
        
        Pair(int val, int min){
            this.val = val;
            this.min = min;
        }
    }
    int min;
    Stack<Pair> stk;
    
    public MinStack() {
        stk = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(stk.isEmpty() || val<min){
            min = val;
            stk.push(new Pair(val,val));
        }else{
            stk.push(new Pair(val,min));
        }
    }
    
    public void pop() {
        stk.pop();
        if(!stk.isEmpty())
            min = stk.peek().min;
    }
    
    public int top() {
        return stk.peek().val;
    }
    
    public int getMin() {
        return stk.peek().min;
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */