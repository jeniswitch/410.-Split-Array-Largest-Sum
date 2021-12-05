class Solution {
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty() && stack.peek() < arr[i]) {
                int temp = stack.pop();
                if(stack.isEmpty()) {
                    res += temp * arr[i];
                }
                else {
                    res += temp * Math.min(stack.peek(), arr[i]);
                }
            }
            stack.push(arr[i]);
        }
        while(stack.size() > 1) {
            res += stack.pop() * stack.peek();
        }
        return res;
    }
}