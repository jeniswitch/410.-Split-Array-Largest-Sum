/*
    8   4   6   2   3
    4   2   2   2   3
*/
class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[prices.length];
        //res[res.length - 1] = prices[prices.length - 1];
        //stack.push(prices[prices.length - 1]);
        for(int i = prices.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && prices[i] < stack.peek()) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                res[i] = prices[i] - stack.peek() >= 0 ? prices[i] - stack.peek() : prices[i];
            }
            else {
                res[i] = prices[i];
            }
            if(stack.isEmpty() || prices[i] > stack.peek()) {
                stack.push(prices[i]);
            }
        }
        return res;
    }
}