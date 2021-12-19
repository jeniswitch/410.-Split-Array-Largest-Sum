class Solution {
    public int binarySearchableNumbers(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        for(int num : nums) {
            while(!stack.isEmpty() && stack.peek() > num) {
                stack.pop();
            }
            if(num > max) {
                stack.push(num);
            }
            max = Math.max(max, num);
        }
        return stack.size();
    }
}