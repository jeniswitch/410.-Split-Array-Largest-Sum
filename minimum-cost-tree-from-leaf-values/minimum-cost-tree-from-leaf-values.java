class Solution {
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(int num : arr) {
            while(!stack.isEmpty() && stack.peek() < num) {
                int temp = stack.pop();
                if(stack.isEmpty()) {
                    res += temp * num;
                }
                else {
                    res += temp * Math.min(stack.peek(), num);
                }
            }
            stack.push(num);
        }
        while(stack.size() > 1) {
            res += stack.pop() * stack.peek();
        }
        return res;
    }
}