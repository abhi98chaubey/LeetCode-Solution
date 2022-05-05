class MyStack {

   Queue <Integer> q = new LinkedList<>();
  
    public void push(int x) {     // Pushes element x on top of the stack
      q.add(x);
      for(int i = 1; i < q.size(); i ++)
        q.add(q.poll());
    }
    
    public int pop() {            //Removes the element on the top of the stack and returns it.
      return q.poll();  
    }
    
    public int top() {            // Returns the element on the top of the stack.
      return q.peek();  
    }
    
    public boolean empty() {      //Returns true if the stack is empty, false otherwise.
      return q.isEmpty();  
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */