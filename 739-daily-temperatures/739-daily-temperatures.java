class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int top = stack.pop();
                res[top] = i - top;
            }
            if(stack.isEmpty() || temperatures[stack.peek()] >= temperatures[i]) {
                stack.push(i);
            }
        }
        return res;
    }
}