class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[heights.length];
        for(int i = heights.length - 1; i >= 0; i--) {
            int count = 0;
            while(!stack.isEmpty() && heights[i] >= heights[stack.peek()]) {
                count++;
                stack.pop();
            }
            res[i] = stack.isEmpty() ? count : count + 1;
            stack.push(i);
        }
        return res;
    }
}