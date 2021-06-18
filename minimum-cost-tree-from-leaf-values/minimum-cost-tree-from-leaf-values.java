class Solution {
    public int mctFromLeafValues(int[] arr) {
        var stack = new Stack<Integer>();
        stack.push(Integer.MAX_VALUE);
        int res = 0;
        for(int i : arr) {
            while(stack.peek() < i) {
                int temp = stack.pop();
                res += temp * Math.min(stack.peek(), i);//key line
            }
            stack.push(i);
        }
        while(stack.size() > 2) {
            res += stack.pop() * stack.peek();
        }
        return res;
    }
}