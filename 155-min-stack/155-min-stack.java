class MinStack {
    private Stack<Integer> stack;
    private Stack<int[]> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || minStack.peek()[0] > val) {
            minStack.push(new int[]{val, 1});
        }
        else if(minStack.peek()[0] == val) {
            minStack.peek()[1]++;
        }
    }
    
    public void pop() {
        int[] rec = minStack.peek();
        if(rec[0] == stack.peek()) {
           if(rec[1] == 1) {
               minStack.pop();
           }
           else {
               minStack.peek()[1]--;
           }
        } 
        stack.pop();
        
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek()[0];
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